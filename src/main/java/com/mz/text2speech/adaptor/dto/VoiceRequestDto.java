package com.mz.text2speech.adaptor.dto;

public class VoiceRequestDto
{
	private String text;

	private String locale;

	private String voice;

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getLocale()
	{
		return locale;
	}

	public void setLocale(String locale)
	{
		this.locale = locale;
	}

	public String getVoice()
	{
		return voice;
	}

	public void setVoice(String voice)
	{
		this.voice = voice;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("VoiceRequestDto{");
		sb.append("text='").append(text).append('\'');
		sb.append(", locale='").append(locale).append('\'');
		sb.append(", voice='").append(voice).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
