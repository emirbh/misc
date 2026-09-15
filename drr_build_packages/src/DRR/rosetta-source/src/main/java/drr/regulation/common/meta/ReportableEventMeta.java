package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.validation.ReportableEventTypeFormatValidator;
import drr.regulation.common.validation.ReportableEventValidator;
import drr.regulation.common.validation.exists.ReportableEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableEvent.class)
public class ReportableEventMeta implements RosettaMetaData<ReportableEvent> {

	@Override
	public List<Validator<? super ReportableEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportableEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableEvent> validator(ValidatorFactory factory) {
		return factory.<ReportableEvent>create(ReportableEventValidator.class);
	}

	@Override
	public Validator<? super ReportableEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableEvent>create(ReportableEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableEvent> validator() {
		return new ReportableEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableEvent> typeFormatValidator() {
		return new ReportableEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableEvent, Set<String>> onlyExistsValidator() {
		return new ReportableEventOnlyExistsValidator();
	}
}
