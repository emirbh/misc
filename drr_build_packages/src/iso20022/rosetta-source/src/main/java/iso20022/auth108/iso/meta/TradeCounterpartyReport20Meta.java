package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.TradeCounterpartyReport20;
import iso20022.auth108.iso.validation.TradeCounterpartyReport20TypeFormatValidator;
import iso20022.auth108.iso.validation.TradeCounterpartyReport20Validator;
import iso20022.auth108.iso.validation.exists.TradeCounterpartyReport20OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeCounterpartyReport20.class)
public class TradeCounterpartyReport20Meta implements RosettaMetaData<TradeCounterpartyReport20> {

	@Override
	public List<Validator<? super TradeCounterpartyReport20>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeCounterpartyReport20, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeCounterpartyReport20> validator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyReport20>create(TradeCounterpartyReport20Validator.class);
	}

	@Override
	public Validator<? super TradeCounterpartyReport20> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyReport20>create(TradeCounterpartyReport20TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyReport20> validator() {
		return new TradeCounterpartyReport20Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyReport20> typeFormatValidator() {
		return new TradeCounterpartyReport20TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeCounterpartyReport20, Set<String>> onlyExistsValidator() {
		return new TradeCounterpartyReport20OnlyExistsValidator();
	}
}
