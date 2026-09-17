package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.SettlementPostponement;
import fpml.consolidated.fx.validation.SettlementPostponementTypeFormatValidator;
import fpml.consolidated.fx.validation.SettlementPostponementValidator;
import fpml.consolidated.fx.validation.exists.SettlementPostponementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPostponement.class)
public class SettlementPostponementMeta implements RosettaMetaData<SettlementPostponement> {

	@Override
	public List<Validator<? super SettlementPostponement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPostponement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPostponement> validator(ValidatorFactory factory) {
		return factory.<SettlementPostponement>create(SettlementPostponementValidator.class);
	}

	@Override
	public Validator<? super SettlementPostponement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPostponement>create(SettlementPostponementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPostponement> validator() {
		return new SettlementPostponementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPostponement> typeFormatValidator() {
		return new SettlementPostponementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPostponement, Set<String>> onlyExistsValidator() {
		return new SettlementPostponementOnlyExistsValidator();
	}
}
