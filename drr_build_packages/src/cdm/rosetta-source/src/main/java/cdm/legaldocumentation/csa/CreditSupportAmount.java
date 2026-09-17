package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CreditSupportAmountMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The total amount one counterparty must deliver to the other at any time: the combination of the Exposure to that party and the net Independent Amounts it must post, minus any agreed Threshold.
 * @version 6.23.0
 */
@RosettaDataType(value="CreditSupportAmount", builder=CreditSupportAmount.CreditSupportAmountBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CreditSupportAmount", model="cdm", builder=CreditSupportAmount.CreditSupportAmountBuilderImpl.class, version="6.23.0")
public interface CreditSupportAmount extends RosettaModelObject {

	CreditSupportAmountMeta metaData = new CreditSupportAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the meaning of credit support amount follows the pre-print definition or deviates from the standard (either based on a rating or some other methodology).
	 */
	CreditSupportAmountEnum getCreditSupportAmount();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	CreditSupportAmount build();
	
	CreditSupportAmount.CreditSupportAmountBuilder toBuilder();
	
	static CreditSupportAmount.CreditSupportAmountBuilder builder() {
		return new CreditSupportAmount.CreditSupportAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportAmount> getType() {
		return CreditSupportAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("creditSupportAmount"), CreditSupportAmountEnum.class, getCreditSupportAmount(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportAmountBuilder extends CreditSupportAmount, RosettaModelObjectBuilder {
		CreditSupportAmount.CreditSupportAmountBuilder setCreditSupportAmount(CreditSupportAmountEnum creditSupportAmount);
		CreditSupportAmount.CreditSupportAmountBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("creditSupportAmount"), CreditSupportAmountEnum.class, getCreditSupportAmount(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		CreditSupportAmount.CreditSupportAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportAmount  ***********************/
	class CreditSupportAmountImpl implements CreditSupportAmount {
		private final CreditSupportAmountEnum creditSupportAmount;
		private final String additionalLanguage;
		
		protected CreditSupportAmountImpl(CreditSupportAmount.CreditSupportAmountBuilder builder) {
			this.creditSupportAmount = builder.getCreditSupportAmount();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("creditSupportAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportAmount")
		public CreditSupportAmountEnum getCreditSupportAmount() {
			return creditSupportAmount;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public CreditSupportAmount build() {
			return this;
		}
		
		@Override
		public CreditSupportAmount.CreditSupportAmountBuilder toBuilder() {
			CreditSupportAmount.CreditSupportAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAmount.CreditSupportAmountBuilder builder) {
			ofNullable(getCreditSupportAmount()).ifPresent(builder::setCreditSupportAmount);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAmount _that = getType().cast(o);
		
			if (!Objects.equals(creditSupportAmount, _that.getCreditSupportAmount())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportAmount != null ? creditSupportAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAmount {" +
				"creditSupportAmount=" + this.creditSupportAmount + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportAmount  ***********************/
	class CreditSupportAmountBuilderImpl implements CreditSupportAmount.CreditSupportAmountBuilder {
	
		protected CreditSupportAmountEnum creditSupportAmount;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("creditSupportAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportAmount")
		public CreditSupportAmountEnum getCreditSupportAmount() {
			return creditSupportAmount;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("creditSupportAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportAmount")
		@Override
		public CreditSupportAmount.CreditSupportAmountBuilder setCreditSupportAmount(CreditSupportAmountEnum _creditSupportAmount) {
			this.creditSupportAmount = _creditSupportAmount == null ? null : _creditSupportAmount;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public CreditSupportAmount.CreditSupportAmountBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public CreditSupportAmount build() {
			return new CreditSupportAmount.CreditSupportAmountImpl(this);
		}
		
		@Override
		public CreditSupportAmount.CreditSupportAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAmount.CreditSupportAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditSupportAmount()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAmount.CreditSupportAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAmount.CreditSupportAmountBuilder o = (CreditSupportAmount.CreditSupportAmountBuilder) other;
			
			
			merger.mergeBasic(getCreditSupportAmount(), o.getCreditSupportAmount(), this::setCreditSupportAmount);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAmount _that = getType().cast(o);
		
			if (!Objects.equals(creditSupportAmount, _that.getCreditSupportAmount())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportAmount != null ? creditSupportAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAmountBuilder {" +
				"creditSupportAmount=" + this.creditSupportAmount + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
