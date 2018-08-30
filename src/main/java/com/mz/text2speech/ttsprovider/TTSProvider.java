package com.mz.text2speech.ttsprovider;

import com.mz.text2speech.exception.TTSException;

import javax.sound.sampled.AudioInputStream;
import java.util.List;
import java.util.Locale;

public interface TTSProvider
{
	Object getInstance();

	Locale getLocale();

	List<Locale> getAvailableLocales();

	void setLocale(Locale locale);

	AudioInputStream generateAudio(String text) throws TTSException;

	String getVoice();

	List<String> getAvailableVoices();

	List<String> getAvailableVoices(Locale locale);

	void setVoice(String voice);

}
