package com.ewolff.user_registration;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.RethrowingFailure;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;

public class UserRegistrationScenarios extends JUnitStories {

	@Override
	public Configuration configuration() {
		LocalizedKeywords keywords = new LocalizedKeywords(new Locale("de"));
		return new MostUsefulConfiguration()
				.useKeywords(keywords)
				.useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
				.useStoryParser(new RegexStoryParser(keywords))

				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useFailureStrategy(new RethrowingFailure())
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withKeywords(keywords)
								.withFormats(Format.HTML, Format.ANSI_CONSOLE)
								.withFailureTrace(true));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(),
				new UserRegistrationSteps());
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()), "**/*.story",
				"**/failing_before*.story");
	}

}
