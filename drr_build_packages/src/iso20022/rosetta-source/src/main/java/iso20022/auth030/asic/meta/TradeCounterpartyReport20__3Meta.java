package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.TradeCounterpartyReport20__3;
import iso20022.auth030.asic.validation.TradeCounterpartyReport20__3TypeFormatValidator;
import iso20022.auth030.asic.validation.TradeCounterpartyReport20__3Validator;
import iso20022.auth030.asic.validation.exists.TradeCounterpartyReport20__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeCounterpartyReport20__3.class)
public class TradeCounterpartyReport20__3Meta implements RosettaMetaData<TradeCounterpartyReport20__3> {

	@Override
	public List<Validator<? super TradeCounterpartyReport20__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeCounterpartyReport20__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeCounterpartyReport20__3> validator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyReport20__3>create(TradeCounterpartyReport20__3Validator.class);
	}

	@Override
	public Validator<? super TradeCounterpartyReport20__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyReport20__3>create(TradeCounterpartyReport20__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyReport20__3> validator() {
		return new TradeCounterpartyReport20__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyReport20__3> typeFormatValidator() {
		return new TradeCounterpartyReport20__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeCounterpartyReport20__3, Set<String>> onlyExistsValidator() {
		return new TradeCounterpartyReport20__3OnlyExistsValidator();
	}
}
