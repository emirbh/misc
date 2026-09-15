package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.IndustrialProductCommodityManufacturing2;
import iso20022.auth030.hkma.dtcc.validation.IndustrialProductCommodityManufacturing2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.IndustrialProductCommodityManufacturing2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.IndustrialProductCommodityManufacturing2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IndustrialProductCommodityManufacturing2.class)
public class IndustrialProductCommodityManufacturing2Meta implements RosettaMetaData<IndustrialProductCommodityManufacturing2> {

	@Override
	public List<Validator<? super IndustrialProductCommodityManufacturing2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndustrialProductCommodityManufacturing2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndustrialProductCommodityManufacturing2> validator(ValidatorFactory factory) {
		return factory.<IndustrialProductCommodityManufacturing2>create(IndustrialProductCommodityManufacturing2Validator.class);
	}

	@Override
	public Validator<? super IndustrialProductCommodityManufacturing2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IndustrialProductCommodityManufacturing2>create(IndustrialProductCommodityManufacturing2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IndustrialProductCommodityManufacturing2> validator() {
		return new IndustrialProductCommodityManufacturing2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super IndustrialProductCommodityManufacturing2> typeFormatValidator() {
		return new IndustrialProductCommodityManufacturing2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndustrialProductCommodityManufacturing2, Set<String>> onlyExistsValidator() {
		return new IndustrialProductCommodityManufacturing2OnlyExistsValidator();
	}
}
