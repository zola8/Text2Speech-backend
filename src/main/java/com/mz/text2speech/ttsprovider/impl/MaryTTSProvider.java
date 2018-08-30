package com.mz.text2speech.ttsprovider.impl;

import com.mz.text2speech.exception.TTSException;
import com.mz.text2speech.ttsprovider.TTSProvider;
import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioInputStream;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class MaryTTSProvider implements TTSProvider
{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MaryTTSProvider.class);

	private MaryInterface marytts;

	{
		try {
			marytts = new LocalMaryInterface();
		} catch (MaryConfigurationException e) {
			LOGGER.error("Couldn't initialize sound interface.", e);
		}
	}

	@Override
	public MaryInterface getInstance()
	{
		return marytts;
	}

	@Override
	public Locale getLocale()
	{
		return marytts.getLocale();
	}

	@Override
	public List<Locale> getAvailableLocales()
	{
		return marytts.getAvailableLocales().stream()
					  .collect(Collectors.toList());
	}

	@Override
	public void setLocale(Locale locale)
	{
		marytts.setLocale(locale);
	}

	@Override
	public AudioInputStream generateAudio(String text) throws TTSException
	{
		try {
			return marytts.generateAudio(text);
		} catch (SynthesisException e) {
			LOGGER.error("Cannot generate audio.", e);
			throw new TTSException("Cannot generate audio.", e);
		}
	}

	@Override
	public String getVoice()
	{
		return marytts.getVoice();
	}

	@Override
	public List<String> getAvailableVoices(Locale locale)
	{
		return marytts.getAvailableVoices(locale).stream()
					  .collect(Collectors.toList());
	}

	@Override
	public List<String> getAvailableVoices()
	{
		return marytts.getAvailableVoices().stream()
					  .collect(Collectors.toList());
	}

	@Override
	public void setVoice(String voiceName)
	{
		marytts.setVoice(voiceName);
	}

}
