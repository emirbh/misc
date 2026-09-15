package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.MarginCollateralReport4;
import iso20022.auth108.iso.validation.MarginCollateralReport4TypeFormatValidator;
import iso20022.auth108.iso.validation.MarginCollateralReport4Validator;
import iso20022.auth108.iso.validation.exists.MarginCollateralReport4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MarginCollateralReport4.class)
public class MarginCollateralReport4Meta implements RosettaMetaData<MarginCollateralReport4> {

	@Override
	public List<Validator<? super MarginCollateralReport4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginCollateralReport4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginCollateralReport4> validator(ValidatorFactory factory) {
		return factory.<MarginCollateralReport4>create(MarginCollateralReport4Validator.class);
	}

	@Override
	public Validator<? super MarginCollateralReport4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarginCollateralReport4>create(MarginCollateralReport4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarginCollateralReport4> validator() {
		return new MarginCollateralReport4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MarginCollateralReport4> typeFormatValidator() {
		return new MarginCollateralReport4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginCollateralReport4, Set<String>> onlyExistsValidator() {
		return new MarginCollateralReport4OnlyExistsValidator();
	}
}
