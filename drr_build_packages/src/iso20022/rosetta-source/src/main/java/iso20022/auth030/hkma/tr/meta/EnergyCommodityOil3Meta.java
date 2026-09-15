package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.EnergyCommodityOil3;
import iso20022.auth030.hkma.tr.validation.EnergyCommodityOil3TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.EnergyCommodityOil3Validator;
import iso20022.auth030.hkma.tr.validation.exists.EnergyCommodityOil3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyCommodityOil3.class)
public class EnergyCommodityOil3Meta implements RosettaMetaData<EnergyCommodityOil3> {

	@Override
	public List<Validator<? super EnergyCommodityOil3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyCommodityOil3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyCommodityOil3> validator(ValidatorFactory factory) {
		return factory.<EnergyCommodityOil3>create(EnergyCommodityOil3Validator.class);
	}

	@Override
	public Validator<? super EnergyCommodityOil3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyCommodityOil3>create(EnergyCommodityOil3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityOil3> validator() {
		return new EnergyCommodityOil3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityOil3> typeFormatValidator() {
		return new EnergyCommodityOil3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyCommodityOil3, Set<String>> onlyExistsValidator() {
		return new EnergyCommodityOil3OnlyExistsValidator();
	}
}
