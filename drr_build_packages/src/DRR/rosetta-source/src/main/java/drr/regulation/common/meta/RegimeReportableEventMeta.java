package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.RegimeReportableEvent;
import drr.regulation.common.validation.RegimeReportableEventTypeFormatValidator;
import drr.regulation.common.validation.RegimeReportableEventValidator;
import drr.regulation.common.validation.exists.RegimeReportableEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=RegimeReportableEvent.class)
public class RegimeReportableEventMeta implements RosettaMetaData<RegimeReportableEvent> {

	@Override
	public List<Validator<? super RegimeReportableEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegimeReportableEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegimeReportableEvent> validator(ValidatorFactory factory) {
		return factory.<RegimeReportableEvent>create(RegimeReportableEventValidator.class);
	}

	@Override
	public Validator<? super RegimeReportableEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegimeReportableEvent>create(RegimeReportableEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegimeReportableEvent> validator() {
		return new RegimeReportableEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegimeReportableEvent> typeFormatValidator() {
		return new RegimeReportableEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegimeReportableEvent, Set<String>> onlyExistsValidator() {
		return new RegimeReportableEventOnlyExistsValidator();
	}
}
