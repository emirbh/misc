package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.NonFinancialSector;
import drr.regulation.common.validation.NonFinancialSectorTypeFormatValidator;
import drr.regulation.common.validation.NonFinancialSectorValidator;
import drr.regulation.common.validation.exists.NonFinancialSectorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=NonFinancialSector.class)
public class NonFinancialSectorMeta implements RosettaMetaData<NonFinancialSector> {

	@Override
	public List<Validator<? super NonFinancialSector>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonFinancialSector, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonFinancialSector> validator(ValidatorFactory factory) {
		return factory.<NonFinancialSector>create(NonFinancialSectorValidator.class);
	}

	@Override
	public Validator<? super NonFinancialSector> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonFinancialSector>create(NonFinancialSectorTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonFinancialSector> validator() {
		return new NonFinancialSectorValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonFinancialSector> typeFormatValidator() {
		return new NonFinancialSectorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonFinancialSector, Set<String>> onlyExistsValidator() {
		return new NonFinancialSectorOnlyExistsValidator();
	}
}
