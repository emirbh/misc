package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.TradeData43__3;
import iso20022.auth030.hkma.tr.validation.TradeData43__3TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.TradeData43__3Validator;
import iso20022.auth030.hkma.tr.validation.exists.TradeData43__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData43__3.class)
public class TradeData43__3Meta implements RosettaMetaData<TradeData43__3> {

	@Override
	public List<Validator<? super TradeData43__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData43__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData43__3> validator(ValidatorFactory factory) {
		return factory.<TradeData43__3>create(TradeData43__3Validator.class);
	}

	@Override
	public Validator<? super TradeData43__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData43__3>create(TradeData43__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__3> validator() {
		return new TradeData43__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__3> typeFormatValidator() {
		return new TradeData43__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData43__3, Set<String>> onlyExistsValidator() {
		return new TradeData43__3OnlyExistsValidator();
	}
}
