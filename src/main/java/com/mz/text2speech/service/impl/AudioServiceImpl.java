package com.mz.text2speech.service.impl;

import com.mz.text2speech.service.AudioService;
import com.mz.text2speech.ttsprovider.TTSProvider;
import marytts.util.data.audio.AudioPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.AudioInputStream;

@Service
public class AudioServiceImpl implements AudioService
{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AudioServiceImpl.class);

	@Autowired private TTSProvider ttsProvider;

	@Override
	public void playAudio(String text)
	{
		try (AudioInputStream audio = ttsProvider.generateAudio(text)) {
			AudioPlayer player = new AudioPlayer(audio);
			player.start();
			player.join();
		} catch (Exception e) {
			LOGGER.error("Error during audio generation.", e);
		}
	}

}
