package net.funshinex.greenjukebox.chatcomponents;

import java.util.Iterator;
import java.util.List;

import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

public class GreenJukeboxChat implements IChatComponent{

	ChatStyle chatStyle;
	String toDisplay;
	List sibs;
	
	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public IChatComponent setChatStyle(ChatStyle chatStyle) {
		this.chatStyle = chatStyle;
		return this;
	}

	@Override
	public ChatStyle getChatStyle() {
		return chatStyle;
	}

	@Override
	public IChatComponent appendText(String var1) {
		this.toDisplay += (" " +  var1);
		return this;
	}

	@Override
	public IChatComponent appendSibling(IChatComponent ret) {
		appendText(ret.getUnformattedText());
		sibs.add(ret);
		return this;
	}

	@Override
	public String getUnformattedTextForChat() {
		return toDisplay;
	}

	@Override
	public String getUnformattedText() {
		return toDisplay;
	}

	@Override
	public String getFormattedText() {
		return toDisplay;
	}

	@Override
	public List getSiblings() {
		return sibs;
	}

	@Override
	public IChatComponent createCopy() {
		return null;
	}

}
