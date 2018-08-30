package com.mz.text2speech.adaptor.rest;

import com.mz.text2speech.adaptor.dto.VoiceRequestDto;
import com.mz.text2speech.service.AudioService;
import com.mz.text2speech.ttsprovider.TTSProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/voice")
public class VoiceController
{
	@Autowired private AudioService audioService;

	@Autowired private TTSProvider ttsProvider;

	@GetMapping("/say")
	public void say(@RequestParam String text)
	{
		audioService.playAudio(text);
	}

	@PostMapping(value = "/say", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void say(@RequestBody VoiceRequestDto dto)
	{
		String locale = dto.getLocale() == null ?
				null :
				dto.getLocale().replaceFirst("_", "-");
		ttsProvider.setLocale(Locale.forLanguageTag(locale));
		ttsProvider.setVoice(dto.getVoice());
		audioService.playAudio(dto.getText());
	}

}
