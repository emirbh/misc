package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CollateralValueMethodMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
 * Details how particular types of collateral are valued (other than in respect of a default).
 * @version 6.23.0
 */
@RosettaDataType(value="CollateralValueMethod", builder=CollateralValueMethod.CollateralValueMethodBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralValueMethod", model="cdm", builder=CollateralValueMethod.CollateralValueMethodBuilderImpl.class, version="6.23.0")
public interface CollateralValueMethod extends RosettaModelObject {

	CollateralValueMethodMeta metaData = new CollateralValueMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Details of how cash collateral is valued.
	 */
	ValueCashEnum getCashCollateral();
	/**
	 * Details of how securities collateral is valued.
	 */
	ValueSecuritiesEnum getSecuritiesCollateral();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	CollateralValueMethod build();
	
	CollateralValueMethod.CollateralValueMethodBuilder toBuilder();
	
	static CollateralValueMethod.CollateralValueMethodBuilder builder() {
		return new CollateralValueMethod.CollateralValueMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralValueMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralValueMethod> getType() {
		return CollateralValueMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cashCollateral"), ValueCashEnum.class, getCashCollateral(), this);
		processor.processBasic(path.newSubPath("securitiesCollateral"), ValueSecuritiesEnum.class, getSecuritiesCollateral(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralValueMethodBuilder extends CollateralValueMethod, RosettaModelObjectBuilder {
		CollateralValueMethod.CollateralValueMethodBuilder setCashCollateral(ValueCashEnum cashCollateral);
		CollateralValueMethod.CollateralValueMethodBuilder setSecuritiesCollateral(ValueSecuritiesEnum securitiesCollateral);
		CollateralValueMethod.CollateralValueMethodBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cashCollateral"), ValueCashEnum.class, getCashCollateral(), this);
			processor.processBasic(path.newSubPath("securitiesCollateral"), ValueSecuritiesEnum.class, getSecuritiesCollateral(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		CollateralValueMethod.CollateralValueMethodBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralValueMethod  ***********************/
	class CollateralValueMethodImpl implements CollateralValueMethod {
		private final ValueCashEnum cashCollateral;
		private final ValueSecuritiesEnum securitiesCollateral;
		private final String additionalLanguage;
		
		protected CollateralValueMethodImpl(CollateralValueMethod.CollateralValueMethodBuilder builder) {
			this.cashCollateral = builder.getCashCollateral();
			this.securitiesCollateral = builder.getSecuritiesCollateral();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("cashCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateral")
		public ValueCashEnum getCashCollateral() {
			return cashCollateral;
		}
		
		@Override
		@RosettaAttribute("securitiesCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("securitiesCollateral")
		public ValueSecuritiesEnum getSecuritiesCollateral() {
			return securitiesCollateral;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public CollateralValueMethod build() {
			return this;
		}
		
		@Override
		public CollateralValueMethod.CollateralValueMethodBuilder toBuilder() {
			CollateralValueMethod.CollateralValueMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralValueMethod.CollateralValueMethodBuilder builder) {
			ofNullable(getCashCollateral()).ifPresent(builder::setCashCollateral);
			ofNullable(getSecuritiesCollateral()).ifPresent(builder::setSecuritiesCollateral);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValueMethod _that = getType().cast(o);
		
			if (!Objects.equals(cashCollateral, _that.getCashCollateral())) return false;
			if (!Objects.equals(securitiesCollateral, _that.getSecuritiesCollateral())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashCollateral != null ? cashCollateral.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securitiesCollateral != null ? securitiesCollateral.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValueMethod {" +
				"cashCollateral=" + this.cashCollateral + ", " +
				"securitiesCollateral=" + this.securitiesCollateral + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralValueMethod  ***********************/
	class CollateralValueMethodBuilderImpl implements CollateralValueMethod.CollateralValueMethodBuilder {
	
		protected ValueCashEnum cashCollateral;
		protected ValueSecuritiesEnum securitiesCollateral;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("cashCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateral")
		public ValueCashEnum getCashCollateral() {
			return cashCollateral;
		}
		
		@Override
		@RosettaAttribute("securitiesCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("securitiesCollateral")
		public ValueSecuritiesEnum getSecuritiesCollateral() {
			return securitiesCollateral;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("cashCollateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashCollateral")
		@Override
		public CollateralValueMethod.CollateralValueMethodBuilder setCashCollateral(ValueCashEnum _cashCollateral) {
			this.cashCollateral = _cashCollateral == null ? null : _cashCollateral;
			return this;
		}
		
		@RosettaAttribute("securitiesCollateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("securitiesCollateral")
		@Override
		public CollateralValueMethod.CollateralValueMethodBuilder setSecuritiesCollateral(ValueSecuritiesEnum _securitiesCollateral) {
			this.securitiesCollateral = _securitiesCollateral == null ? null : _securitiesCollateral;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public CollateralValueMethod.CollateralValueMethodBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public CollateralValueMethod build() {
			return new CollateralValueMethod.CollateralValueMethodImpl(this);
		}
		
		@Override
		public CollateralValueMethod.CollateralValueMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValueMethod.CollateralValueMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashCollateral()!=null) return true;
			if (getSecuritiesCollateral()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValueMethod.CollateralValueMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralValueMethod.CollateralValueMethodBuilder o = (CollateralValueMethod.CollateralValueMethodBuilder) other;
			
			
			merger.mergeBasic(getCashCollateral(), o.getCashCollateral(), this::setCashCollateral);
			merger.mergeBasic(getSecuritiesCollateral(), o.getSecuritiesCollateral(), this::setSecuritiesCollateral);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValueMethod _that = getType().cast(o);
		
			if (!Objects.equals(cashCollateral, _that.getCashCollateral())) return false;
			if (!Objects.equals(securitiesCollateral, _that.getSecuritiesCollateral())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashCollateral != null ? cashCollateral.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securitiesCollateral != null ? securitiesCollateral.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValueMethodBuilder {" +
				"cashCollateral=" + this.cashCollateral + ", " +
				"securitiesCollateral=" + this.securitiesCollateral + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
