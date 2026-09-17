package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.ird.validation.CashSettlementTypeFormatValidator;
import fpml.consolidated.ird.validation.CashSettlementValidator;
import fpml.consolidated.ird.validation.datarule.CashSettlementChoice;
import fpml.consolidated.ird.validation.exists.CashSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashSettlement.class)
public class CashSettlementMeta implements RosettaMetaData<CashSettlement> {

	@Override
	public List<Validator<? super CashSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CashSettlement>create(CashSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CashSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashSettlement> validator(ValidatorFactory factory) {
		return factory.<CashSettlement>create(CashSettlementValidator.class);
	}

	@Override
	public Validator<? super CashSettlement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashSettlement>create(CashSettlementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashSettlement> validator() {
		return new CashSettlementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashSettlement> typeFormatValidator() {
		return new CashSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashSettlement, Set<String>> onlyExistsValidator() {
		return new CashSettlementOnlyExistsValidator();
	}
}
