package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbSingleStock;
import drr.standards.iosco.upi.validation.AnnaDsbSingleStockTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbSingleStockValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbSingleStockOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbSingleStock.class)
public class AnnaDsbSingleStockMeta implements RosettaMetaData<AnnaDsbSingleStock> {

	@Override
	public List<Validator<? super AnnaDsbSingleStock>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbSingleStock, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbSingleStock> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbSingleStock>create(AnnaDsbSingleStockValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbSingleStock> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbSingleStock>create(AnnaDsbSingleStockTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbSingleStock> validator() {
		return new AnnaDsbSingleStockValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbSingleStock> typeFormatValidator() {
		return new AnnaDsbSingleStockTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbSingleStock, Set<String>> onlyExistsValidator() {
		return new AnnaDsbSingleStockOnlyExistsValidator();
	}
}
