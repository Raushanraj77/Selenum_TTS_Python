package SpeachReporting;
import java.util.Locale;
import marytts.modules.synthesis.Voice;
import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer; 
import javax.speech.synthesis.SynthesizerModeDesc; 

public class SpeachReporting {
     TextToSpeech tts = new TextToSpeech();

	public void speachReport(String logStatement) throws EngineException, AudioException, EngineStateError, IllegalArgumentException, InterruptedException
	{
       tts.setVoice("cmu-slt-hsmm");
	   tts.speak(logStatement, 2.0f, false, true);
    
	}
}
