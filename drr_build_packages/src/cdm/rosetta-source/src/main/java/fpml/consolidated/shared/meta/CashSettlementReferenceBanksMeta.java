package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.validation.CashSettlementReferenceBanksTypeFormatValidator;
import fpml.consolidated.shared.validation.CashSettlementReferenceBanksValidator;
import fpml.consolidated.shared.validation.exists.CashSettlementReferenceBanksOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashSettlementReferenceBanks.class)
public class CashSettlementReferenceBanksMeta implements RosettaMetaData<CashSettlementReferenceBanks> {

	@Override
	public List<Validator<? super CashSettlementReferenceBanks>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashSettlementReferenceBanks, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashSettlementReferenceBanks> validator(ValidatorFactory factory) {
		return factory.<CashSettlementReferenceBanks>create(CashSettlementReferenceBanksValidator.class);
	}

	@Override
	public Validator<? super CashSettlementReferenceBanks> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashSettlementReferenceBanks>create(CashSettlementReferenceBanksTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashSettlementReferenceBanks> validator() {
		return new CashSettlementReferenceBanksValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashSettlementReferenceBanks> typeFormatValidator() {
		return new CashSettlementReferenceBanksTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashSettlementReferenceBanks, Set<String>> onlyExistsValidator() {
		return new CashSettlementReferenceBanksOnlyExistsValidator();
	}
}
