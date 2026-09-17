package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ReportingCurrencyType;
import fpml.consolidated.asset.validation.ReportingCurrencyTypeTypeFormatValidator;
import fpml.consolidated.asset.validation.ReportingCurrencyTypeValidator;
import fpml.consolidated.asset.validation.exists.ReportingCurrencyTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportingCurrencyType.class)
public class ReportingCurrencyTypeMeta implements RosettaMetaData<ReportingCurrencyType> {

	@Override
	public List<Validator<? super ReportingCurrencyType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingCurrencyType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingCurrencyType> validator(ValidatorFactory factory) {
		return factory.<ReportingCurrencyType>create(ReportingCurrencyTypeValidator.class);
	}

	@Override
	public Validator<? super ReportingCurrencyType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingCurrencyType>create(ReportingCurrencyTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingCurrencyType> validator() {
		return new ReportingCurrencyTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingCurrencyType> typeFormatValidator() {
		return new ReportingCurrencyTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingCurrencyType, Set<String>> onlyExistsValidator() {
		return new ReportingCurrencyTypeOnlyExistsValidator();
	}
}
