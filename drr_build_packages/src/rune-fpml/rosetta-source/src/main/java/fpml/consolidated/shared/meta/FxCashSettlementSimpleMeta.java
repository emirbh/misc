package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.validation.FxCashSettlementSimpleTypeFormatValidator;
import fpml.consolidated.shared.validation.FxCashSettlementSimpleValidator;
import fpml.consolidated.shared.validation.datarule.FxCashSettlementSimpleChoice;
import fpml.consolidated.shared.validation.exists.FxCashSettlementSimpleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxCashSettlementSimple.class)
public class FxCashSettlementSimpleMeta implements RosettaMetaData<FxCashSettlementSimple> {

	@Override
	public List<Validator<? super FxCashSettlementSimple>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxCashSettlementSimple>create(FxCashSettlementSimpleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxCashSettlementSimple, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxCashSettlementSimple> validator(ValidatorFactory factory) {
		return factory.<FxCashSettlementSimple>create(FxCashSettlementSimpleValidator.class);
	}

	@Override
	public Validator<? super FxCashSettlementSimple> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxCashSettlementSimple>create(FxCashSettlementSimpleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxCashSettlementSimple> validator() {
		return new FxCashSettlementSimpleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxCashSettlementSimple> typeFormatValidator() {
		return new FxCashSettlementSimpleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCashSettlementSimple, Set<String>> onlyExistsValidator() {
		return new FxCashSettlementSimpleOnlyExistsValidator();
	}
}
