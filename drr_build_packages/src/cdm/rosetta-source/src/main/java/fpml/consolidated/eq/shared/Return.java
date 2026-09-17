package fpml.consolidated.eq.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.eq.shared.meta.ReturnMeta;
import fpml.consolidated.fpmlenum.ReturnTypeEnum;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the dividend return conditions applicable to the swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the dividend return conditions applicable to the swap.
 *
 */
@RosettaDataType(value="Return", builder=Return.ReturnBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Return", model="fpml", builder=Return.ReturnBuilderImpl.class, version="2.1.1")
public interface Return extends RosettaModelObject {

	ReturnMeta metaData = new ReturnMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the type of return associated with the return swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the type of return associated with the return swap.
	 *
	 */
	ReturnTypeEnum getReturnType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the conditions governing the payment of the dividends to the receiver of the equity return. With the exception of the dividend payout ratio, which is defined for each of the underlying components.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the conditions governing the payment of the dividends to the receiver of the equity return. With the exception of the dividend payout ratio, which is defined for each of the underlying components.
	 *
	 */
	DividendConditions getDividendConditions();

	/*********************** Build Methods  ***********************/
	Return build();
	
	Return.ReturnBuilder toBuilder();
	
	static Return.ReturnBuilder builder() {
		return new Return.ReturnBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Return> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Return> getType() {
		return Return.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("returnType"), ReturnTypeEnum.class, getReturnType(), this);
		processRosetta(path.newSubPath("dividendConditions"), processor, DividendConditions.class, getDividendConditions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnBuilder extends Return, RosettaModelObjectBuilder {
		DividendConditions.DividendConditionsBuilder getOrCreateDividendConditions();
		@Override
		DividendConditions.DividendConditionsBuilder getDividendConditions();
		Return.ReturnBuilder setReturnType(ReturnTypeEnum returnType);
		Return.ReturnBuilder setDividendConditions(DividendConditions dividendConditions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("returnType"), ReturnTypeEnum.class, getReturnType(), this);
			processRosetta(path.newSubPath("dividendConditions"), processor, DividendConditions.DividendConditionsBuilder.class, getDividendConditions());
		}
		

		Return.ReturnBuilder prune();
	}

	/*********************** Immutable Implementation of Return  ***********************/
	class ReturnImpl implements Return {
		private final ReturnTypeEnum returnType;
		private final DividendConditions dividendConditions;
		
		protected ReturnImpl(Return.ReturnBuilder builder) {
			this.returnType = builder.getReturnType();
			this.dividendConditions = ofNullable(builder.getDividendConditions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("returnType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("returnType")
		public ReturnTypeEnum getReturnType() {
			return returnType;
		}
		
		@Override
		@RosettaAttribute("dividendConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendConditions")
		public DividendConditions getDividendConditions() {
			return dividendConditions;
		}
		
		@Override
		public Return build() {
			return this;
		}
		
		@Override
		public Return.ReturnBuilder toBuilder() {
			Return.ReturnBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Return.ReturnBuilder builder) {
			ofNullable(getReturnType()).ifPresent(builder::setReturnType);
			ofNullable(getDividendConditions()).ifPresent(builder::setDividendConditions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Return _that = getType().cast(o);
		
			if (!Objects.equals(returnType, _that.getReturnType())) return false;
			if (!Objects.equals(dividendConditions, _that.getDividendConditions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnType != null ? returnType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendConditions != null ? dividendConditions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Return {" +
				"returnType=" + this.returnType + ", " +
				"dividendConditions=" + this.dividendConditions +
			'}';
		}
	}

	/*********************** Builder Implementation of Return  ***********************/
	class ReturnBuilderImpl implements Return.ReturnBuilder {
	
		protected ReturnTypeEnum returnType;
		protected DividendConditions.DividendConditionsBuilder dividendConditions;
		
		@Override
		@RosettaAttribute("returnType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("returnType")
		public ReturnTypeEnum getReturnType() {
			return returnType;
		}
		
		@Override
		@RosettaAttribute("dividendConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendConditions")
		public DividendConditions.DividendConditionsBuilder getDividendConditions() {
			return dividendConditions;
		}
		
		@Override
		public DividendConditions.DividendConditionsBuilder getOrCreateDividendConditions() {
			DividendConditions.DividendConditionsBuilder result;
			if (dividendConditions!=null) {
				result = dividendConditions;
			}
			else {
				result = dividendConditions = DividendConditions.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("returnType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("returnType")
		@Override
		public Return.ReturnBuilder setReturnType(ReturnTypeEnum _returnType) {
			this.returnType = _returnType == null ? null : _returnType;
			return this;
		}
		
		@RosettaAttribute("dividendConditions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendConditions")
		@Override
		public Return.ReturnBuilder setDividendConditions(DividendConditions _dividendConditions) {
			this.dividendConditions = _dividendConditions == null ? null : _dividendConditions.toBuilder();
			return this;
		}
		
		@Override
		public Return build() {
			return new Return.ReturnImpl(this);
		}
		
		@Override
		public Return.ReturnBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Return.ReturnBuilder prune() {
			if (dividendConditions!=null && !dividendConditions.prune().hasData()) dividendConditions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnType()!=null) return true;
			if (getDividendConditions()!=null && getDividendConditions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Return.ReturnBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Return.ReturnBuilder o = (Return.ReturnBuilder) other;
			
			merger.mergeRosetta(getDividendConditions(), o.getDividendConditions(), this::setDividendConditions);
			
			merger.mergeBasic(getReturnType(), o.getReturnType(), this::setReturnType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Return _that = getType().cast(o);
		
			if (!Objects.equals(returnType, _that.getReturnType())) return false;
			if (!Objects.equals(dividendConditions, _that.getDividendConditions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnType != null ? returnType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendConditions != null ? dividendConditions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnBuilder {" +
				"returnType=" + this.returnType + ", " +
				"dividendConditions=" + this.dividendConditions +
			'}';
		}
	}
}
