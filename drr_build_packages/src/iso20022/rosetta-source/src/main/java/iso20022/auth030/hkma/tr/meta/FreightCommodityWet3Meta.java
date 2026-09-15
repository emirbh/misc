package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.FreightCommodityWet3;
import iso20022.auth030.hkma.tr.validation.FreightCommodityWet3TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.FreightCommodityWet3Validator;
import iso20022.auth030.hkma.tr.validation.exists.FreightCommodityWet3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FreightCommodityWet3.class)
public class FreightCommodityWet3Meta implements RosettaMetaData<FreightCommodityWet3> {

	@Override
	public List<Validator<? super FreightCommodityWet3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FreightCommodityWet3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FreightCommodityWet3> validator(ValidatorFactory factory) {
		return factory.<FreightCommodityWet3>create(FreightCommodityWet3Validator.class);
	}

	@Override
	public Validator<? super FreightCommodityWet3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FreightCommodityWet3>create(FreightCommodityWet3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FreightCommodityWet3> validator() {
		return new FreightCommodityWet3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FreightCommodityWet3> typeFormatValidator() {
		return new FreightCommodityWet3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FreightCommodityWet3, Set<String>> onlyExistsValidator() {
		return new FreightCommodityWet3OnlyExistsValidator();
	}
}
