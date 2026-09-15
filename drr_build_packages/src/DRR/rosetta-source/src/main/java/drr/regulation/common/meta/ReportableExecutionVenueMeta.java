package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.validation.ReportableExecutionVenueTypeFormatValidator;
import drr.regulation.common.validation.ReportableExecutionVenueValidator;
import drr.regulation.common.validation.datarule.ReportableExecutionVenueSEFOrDCMAnonymousIndicator;
import drr.regulation.common.validation.exists.ReportableExecutionVenueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableExecutionVenue.class)
public class ReportableExecutionVenueMeta implements RosettaMetaData<ReportableExecutionVenue> {

	@Override
	public List<Validator<? super ReportableExecutionVenue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReportableExecutionVenue>create(ReportableExecutionVenueSEFOrDCMAnonymousIndicator.class)
		);
	}
	
	@Override
	public List<Function<? super ReportableExecutionVenue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableExecutionVenue> validator(ValidatorFactory factory) {
		return factory.<ReportableExecutionVenue>create(ReportableExecutionVenueValidator.class);
	}

	@Override
	public Validator<? super ReportableExecutionVenue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableExecutionVenue>create(ReportableExecutionVenueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableExecutionVenue> validator() {
		return new ReportableExecutionVenueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableExecutionVenue> typeFormatValidator() {
		return new ReportableExecutionVenueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableExecutionVenue, Set<String>> onlyExistsValidator() {
		return new ReportableExecutionVenueOnlyExistsValidator();
	}
}
