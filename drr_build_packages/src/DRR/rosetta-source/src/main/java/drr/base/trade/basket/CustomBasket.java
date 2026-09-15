package drr.base.trade.basket;

import cdm.base.staticdata.party.PartyIdentifier;
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
import drr.base.trade.basket.meta.CustomBasketMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the identifiers for custom Basket
 * @version 7.7.0
 */
@RosettaDataType(value="CustomBasket", builder=CustomBasket.CustomBasketBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CustomBasket", model="drr", builder=CustomBasket.CustomBasketBuilderImpl.class, version="7.7.0")
public interface CustomBasket extends RosettaModelObject {

	CustomBasketMeta metaData = new CustomBasketMeta();

	/*********************** Getter Methods  ***********************/
	PartyIdentifier getBasketStructurerLei();
	String getCustomBasketCode();

	/*********************** Build Methods  ***********************/
	CustomBasket build();
	
	CustomBasket.CustomBasketBuilder toBuilder();
	
	static CustomBasket.CustomBasketBuilder builder() {
		return new CustomBasket.CustomBasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustomBasket> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustomBasket> getType() {
		return CustomBasket.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("basketStructurerLei"), processor, PartyIdentifier.class, getBasketStructurerLei());
		processor.processBasic(path.newSubPath("customBasketCode"), String.class, getCustomBasketCode(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustomBasketBuilder extends CustomBasket, RosettaModelObjectBuilder {
		PartyIdentifier.PartyIdentifierBuilder getOrCreateBasketStructurerLei();
		@Override
		PartyIdentifier.PartyIdentifierBuilder getBasketStructurerLei();
		CustomBasket.CustomBasketBuilder setBasketStructurerLei(PartyIdentifier basketStructurerLei);
		CustomBasket.CustomBasketBuilder setCustomBasketCode(String customBasketCode);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("basketStructurerLei"), processor, PartyIdentifier.PartyIdentifierBuilder.class, getBasketStructurerLei());
			processor.processBasic(path.newSubPath("customBasketCode"), String.class, getCustomBasketCode(), this);
		}
		

		CustomBasket.CustomBasketBuilder prune();
	}

	/*********************** Immutable Implementation of CustomBasket  ***********************/
	class CustomBasketImpl implements CustomBasket {
		private final PartyIdentifier basketStructurerLei;
		private final String customBasketCode;
		
		protected CustomBasketImpl(CustomBasket.CustomBasketBuilder builder) {
			this.basketStructurerLei = ofNullable(builder.getBasketStructurerLei()).map(f->f.build()).orElse(null);
			this.customBasketCode = builder.getCustomBasketCode();
		}
		
		@Override
		@RosettaAttribute("basketStructurerLei")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basketStructurerLei")
		public PartyIdentifier getBasketStructurerLei() {
			return basketStructurerLei;
		}
		
		@Override
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customBasketCode")
		public String getCustomBasketCode() {
			return customBasketCode;
		}
		
		@Override
		public CustomBasket build() {
			return this;
		}
		
		@Override
		public CustomBasket.CustomBasketBuilder toBuilder() {
			CustomBasket.CustomBasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustomBasket.CustomBasketBuilder builder) {
			ofNullable(getBasketStructurerLei()).ifPresent(builder::setBasketStructurerLei);
			ofNullable(getCustomBasketCode()).ifPresent(builder::setCustomBasketCode);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustomBasket _that = getType().cast(o);
		
			if (!Objects.equals(basketStructurerLei, _that.getBasketStructurerLei())) return false;
			if (!Objects.equals(customBasketCode, _that.getCustomBasketCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketStructurerLei != null ? basketStructurerLei.hashCode() : 0);
			_result = 31 * _result + (customBasketCode != null ? customBasketCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustomBasket {" +
				"basketStructurerLei=" + this.basketStructurerLei + ", " +
				"customBasketCode=" + this.customBasketCode +
			'}';
		}
	}

	/*********************** Builder Implementation of CustomBasket  ***********************/
	class CustomBasketBuilderImpl implements CustomBasket.CustomBasketBuilder {
	
		protected PartyIdentifier.PartyIdentifierBuilder basketStructurerLei;
		protected String customBasketCode;
		
		@Override
		@RosettaAttribute("basketStructurerLei")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basketStructurerLei")
		public PartyIdentifier.PartyIdentifierBuilder getBasketStructurerLei() {
			return basketStructurerLei;
		}
		
		@Override
		public PartyIdentifier.PartyIdentifierBuilder getOrCreateBasketStructurerLei() {
			PartyIdentifier.PartyIdentifierBuilder result;
			if (basketStructurerLei!=null) {
				result = basketStructurerLei;
			}
			else {
				result = basketStructurerLei = PartyIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customBasketCode")
		public String getCustomBasketCode() {
			return customBasketCode;
		}
		
		@RosettaAttribute("basketStructurerLei")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basketStructurerLei")
		@Override
		public CustomBasket.CustomBasketBuilder setBasketStructurerLei(PartyIdentifier _basketStructurerLei) {
			this.basketStructurerLei = _basketStructurerLei == null ? null : _basketStructurerLei.toBuilder();
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public CustomBasket.CustomBasketBuilder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@Override
		public CustomBasket build() {
			return new CustomBasket.CustomBasketImpl(this);
		}
		
		@Override
		public CustomBasket.CustomBasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustomBasket.CustomBasketBuilder prune() {
			if (basketStructurerLei!=null && !basketStructurerLei.prune().hasData()) basketStructurerLei = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketStructurerLei()!=null && getBasketStructurerLei().hasData()) return true;
			if (getCustomBasketCode()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustomBasket.CustomBasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustomBasket.CustomBasketBuilder o = (CustomBasket.CustomBasketBuilder) other;
			
			merger.mergeRosetta(getBasketStructurerLei(), o.getBasketStructurerLei(), this::setBasketStructurerLei);
			
			merger.mergeBasic(getCustomBasketCode(), o.getCustomBasketCode(), this::setCustomBasketCode);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustomBasket _that = getType().cast(o);
		
			if (!Objects.equals(basketStructurerLei, _that.getBasketStructurerLei())) return false;
			if (!Objects.equals(customBasketCode, _that.getCustomBasketCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketStructurerLei != null ? basketStructurerLei.hashCode() : 0);
			_result = 31 * _result + (customBasketCode != null ? customBasketCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustomBasketBuilder {" +
				"basketStructurerLei=" + this.basketStructurerLei + ", " +
				"customBasketCode=" + this.customBasketCode +
			'}';
		}
	}
}
