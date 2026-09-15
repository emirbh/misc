package drr.regulation.esma.emir.refit.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.esma.emir.refit.valuation.NonReportable;
import drr.regulation.esma.emir.refit.valuation.validation.NonReportableTypeFormatValidator;
import drr.regulation.esma.emir.refit.valuation.validation.NonReportableValidator;
import drr.regulation.esma.emir.refit.valuation.validation.exists.NonReportableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=NonReportable.class)
public class NonReportableMeta implements RosettaMetaData<NonReportable> {

	@Override
	public List<Validator<? super NonReportable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonReportable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonReportable> validator(ValidatorFactory factory) {
		return factory.<NonReportable>create(NonReportableValidator.class);
	}

	@Override
	public Validator<? super NonReportable> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonReportable>create(NonReportableTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonReportable> validator() {
		return new NonReportableValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonReportable> typeFormatValidator() {
		return new NonReportableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonReportable, Set<String>> onlyExistsValidator() {
		return new NonReportableOnlyExistsValidator();
	}
}
