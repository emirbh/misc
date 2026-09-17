package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.DatedAsOfDate;
import cdm.legaldocumentation.csa.validation.DatedAsOfDateTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.DatedAsOfDateValidator;
import cdm.legaldocumentation.csa.validation.exists.DatedAsOfDateOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=DatedAsOfDate.class)
public class DatedAsOfDateMeta implements RosettaMetaData<DatedAsOfDate> {

	@Override
	public List<Validator<? super DatedAsOfDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DatedAsOfDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DatedAsOfDate> validator(ValidatorFactory factory) {
		return factory.<DatedAsOfDate>create(DatedAsOfDateValidator.class);
	}

	@Override
	public Validator<? super DatedAsOfDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DatedAsOfDate>create(DatedAsOfDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DatedAsOfDate> validator() {
		return new DatedAsOfDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DatedAsOfDate> typeFormatValidator() {
		return new DatedAsOfDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DatedAsOfDate, Set<String>> onlyExistsValidator() {
		return new DatedAsOfDateOnlyExistsValidator();
	}
}
