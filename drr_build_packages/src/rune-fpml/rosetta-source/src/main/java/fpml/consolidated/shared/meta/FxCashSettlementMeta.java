package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.validation.FxCashSettlementTypeFormatValidator;
import fpml.consolidated.shared.validation.FxCashSettlementValidator;
import fpml.consolidated.shared.validation.datarule.FxCashSettlementChoice;
import fpml.consolidated.shared.validation.exists.FxCashSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxCashSettlement.class)
public class FxCashSettlementMeta implements RosettaMetaData<FxCashSettlement> {

	@Override
	public List<Validator<? super FxCashSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxCashSettlement>create(FxCashSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxCashSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxCashSettlement> validator(ValidatorFactory factory) {
		return factory.<FxCashSettlement>create(FxCashSettlementValidator.class);
	}

	@Override
	public Validator<? super FxCashSettlement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxCashSettlement>create(FxCashSettlementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxCashSettlement> validator() {
		return new FxCashSettlementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxCashSettlement> typeFormatValidator() {
		return new FxCashSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCashSettlement, Set<String>> onlyExistsValidator() {
		return new FxCashSettlementOnlyExistsValidator();
	}
}
