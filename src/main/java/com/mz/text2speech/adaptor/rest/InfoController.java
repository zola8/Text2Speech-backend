package com.mz.text2speech.adaptor.rest;

import com.mz.text2speech.ttsprovider.TTSProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController
{
	@Autowired private TTSProvider ttsProvider;

	@GetMapping("/info")
	public String htmlInfo()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("<h3> Locale </h3>");
		sb.append("Current locale = ").append(ttsProvider.getLocale())
		  .append("<br/>");
		sb.append("Available locales = ")
		  .append(ttsProvider.getAvailableLocales()).append("<br/>");

		sb.append("<h3> Voice </h3>");
		sb.append("Current voice = ").append(ttsProvider.getVoice())
		  .append("<br/>");
		sb.append("Available voices = ")
		  .append(ttsProvider.getAvailableVoices()).append("<br/>");
		sb.append("Available voices with current locale = ")
		  .append(ttsProvider.getAvailableVoices(ttsProvider.getLocale()))
		  .append("<br/><br/>");

		ttsProvider.getAvailableLocales().stream().forEach(locale -> {
			sb.append(locale).append("<ul>");
			ttsProvider.getAvailableVoices(locale).stream().forEach(voice -> {
				sb.append("<li>").append(voice).append("</li>");
			});
			sb.append("</ul>");
		});

		return sb.toString();
	}

}
