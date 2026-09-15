package drr.base.margin;

import cdm.event.common.TradeIdentifier;
import cdm.product.collateral.Collateral;
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
import drr.base.margin.meta.CollateralDetailsMeta;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CollateralDetails", builder=CollateralDetails.CollateralDetailsBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CollateralDetails", model="drr", builder=CollateralDetails.CollateralDetailsBuilderImpl.class, version="7.7.0")
public interface CollateralDetails extends RosettaModelObject {

	CollateralDetailsMeta metaData = new CollateralDetailsMeta();

	/*********************** Getter Methods  ***********************/
	ZonedDateTime getCollateralTimestamp();
	Collateral getCollateral();
	TradeIdentifier getUniqueTradeIdentifier();
	MarginActionEnum getAction();
	CollateralisationType3Code getCollateralisationCategory();

	/*********************** Build Methods  ***********************/
	CollateralDetails build();
	
	CollateralDetails.CollateralDetailsBuilder toBuilder();
	
	static CollateralDetails.CollateralDetailsBuilder builder() {
		return new CollateralDetails.CollateralDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralDetails> getType() {
		return CollateralDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("collateralTimestamp"), ZonedDateTime.class, getCollateralTimestamp(), this);
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
		processRosetta(path.newSubPath("uniqueTradeIdentifier"), processor, TradeIdentifier.class, getUniqueTradeIdentifier());
		processor.processBasic(path.newSubPath("action"), MarginActionEnum.class, getAction(), this);
		processor.processBasic(path.newSubPath("collateralisationCategory"), CollateralisationType3Code.class, getCollateralisationCategory(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralDetailsBuilder extends CollateralDetails, RosettaModelObjectBuilder {
		Collateral.CollateralBuilder getOrCreateCollateral();
		@Override
		Collateral.CollateralBuilder getCollateral();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateUniqueTradeIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getUniqueTradeIdentifier();
		CollateralDetails.CollateralDetailsBuilder setCollateralTimestamp(ZonedDateTime collateralTimestamp);
		CollateralDetails.CollateralDetailsBuilder setCollateral(Collateral collateral);
		CollateralDetails.CollateralDetailsBuilder setUniqueTradeIdentifier(TradeIdentifier uniqueTradeIdentifier);
		CollateralDetails.CollateralDetailsBuilder setAction(MarginActionEnum action);
		CollateralDetails.CollateralDetailsBuilder setCollateralisationCategory(CollateralisationType3Code collateralisationCategory);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("collateralTimestamp"), ZonedDateTime.class, getCollateralTimestamp(), this);
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
			processRosetta(path.newSubPath("uniqueTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getUniqueTradeIdentifier());
			processor.processBasic(path.newSubPath("action"), MarginActionEnum.class, getAction(), this);
			processor.processBasic(path.newSubPath("collateralisationCategory"), CollateralisationType3Code.class, getCollateralisationCategory(), this);
		}
		

		CollateralDetails.CollateralDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralDetails  ***********************/
	class CollateralDetailsImpl implements CollateralDetails {
		private final ZonedDateTime collateralTimestamp;
		private final Collateral collateral;
		private final TradeIdentifier uniqueTradeIdentifier;
		private final MarginActionEnum action;
		private final CollateralisationType3Code collateralisationCategory;
		
		protected CollateralDetailsImpl(CollateralDetails.CollateralDetailsBuilder builder) {
			this.collateralTimestamp = builder.getCollateralTimestamp();
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
			this.uniqueTradeIdentifier = ofNullable(builder.getUniqueTradeIdentifier()).map(f->f.build()).orElse(null);
			this.action = builder.getAction();
			this.collateralisationCategory = builder.getCollateralisationCategory();
		}
		
		@Override
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralTimestamp")
		public ZonedDateTime getCollateralTimestamp() {
			return collateralTimestamp;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateral")
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		@RosettaAttribute("uniqueTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTradeIdentifier")
		public TradeIdentifier getUniqueTradeIdentifier() {
			return uniqueTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("action")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("action")
		public MarginActionEnum getAction() {
			return action;
		}
		
		@Override
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralisationCategory")
		public CollateralisationType3Code getCollateralisationCategory() {
			return collateralisationCategory;
		}
		
		@Override
		public CollateralDetails build() {
			return this;
		}
		
		@Override
		public CollateralDetails.CollateralDetailsBuilder toBuilder() {
			CollateralDetails.CollateralDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralDetails.CollateralDetailsBuilder builder) {
			ofNullable(getCollateralTimestamp()).ifPresent(builder::setCollateralTimestamp);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getUniqueTradeIdentifier()).ifPresent(builder::setUniqueTradeIdentifier);
			ofNullable(getAction()).ifPresent(builder::setAction);
			ofNullable(getCollateralisationCategory()).ifPresent(builder::setCollateralisationCategory);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralDetails _that = getType().cast(o);
		
			if (!Objects.equals(collateralTimestamp, _that.getCollateralTimestamp())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(uniqueTradeIdentifier, _that.getUniqueTradeIdentifier())) return false;
			if (!Objects.equals(action, _that.getAction())) return false;
			if (!Objects.equals(collateralisationCategory, _that.getCollateralisationCategory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralTimestamp != null ? collateralTimestamp.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (uniqueTradeIdentifier != null ? uniqueTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (action != null ? action.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (collateralisationCategory != null ? collateralisationCategory.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralDetails {" +
				"collateralTimestamp=" + this.collateralTimestamp + ", " +
				"collateral=" + this.collateral + ", " +
				"uniqueTradeIdentifier=" + this.uniqueTradeIdentifier + ", " +
				"action=" + this.action + ", " +
				"collateralisationCategory=" + this.collateralisationCategory +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralDetails  ***********************/
	class CollateralDetailsBuilderImpl implements CollateralDetails.CollateralDetailsBuilder {
	
		protected ZonedDateTime collateralTimestamp;
		protected Collateral.CollateralBuilder collateral;
		protected TradeIdentifier.TradeIdentifierBuilder uniqueTradeIdentifier;
		protected MarginActionEnum action;
		protected CollateralisationType3Code collateralisationCategory;
		
		@Override
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralTimestamp")
		public ZonedDateTime getCollateralTimestamp() {
			return collateralTimestamp;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateral")
		public Collateral.CollateralBuilder getCollateral() {
			return collateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateral() {
			Collateral.CollateralBuilder result;
			if (collateral!=null) {
				result = collateral;
			}
			else {
				result = collateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("uniqueTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getUniqueTradeIdentifier() {
			return uniqueTradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateUniqueTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (uniqueTradeIdentifier!=null) {
				result = uniqueTradeIdentifier;
			}
			else {
				result = uniqueTradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("action")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("action")
		public MarginActionEnum getAction() {
			return action;
		}
		
		@Override
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralisationCategory")
		public CollateralisationType3Code getCollateralisationCategory() {
			return collateralisationCategory;
		}
		
		@RosettaAttribute("collateralTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collateralTimestamp")
		@Override
		public CollateralDetails.CollateralDetailsBuilder setCollateralTimestamp(ZonedDateTime _collateralTimestamp) {
			this.collateralTimestamp = _collateralTimestamp == null ? null : _collateralTimestamp;
			return this;
		}
		
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateral")
		@Override
		public CollateralDetails.CollateralDetailsBuilder setCollateral(Collateral _collateral) {
			this.collateral = _collateral == null ? null : _collateral.toBuilder();
			return this;
		}
		
		@RosettaAttribute("uniqueTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTradeIdentifier")
		@Override
		public CollateralDetails.CollateralDetailsBuilder setUniqueTradeIdentifier(TradeIdentifier _uniqueTradeIdentifier) {
			this.uniqueTradeIdentifier = _uniqueTradeIdentifier == null ? null : _uniqueTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("action")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("action")
		@Override
		public CollateralDetails.CollateralDetailsBuilder setAction(MarginActionEnum _action) {
			this.action = _action == null ? null : _action;
			return this;
		}
		
		@RosettaAttribute("collateralisationCategory")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collateralisationCategory")
		@Override
		public CollateralDetails.CollateralDetailsBuilder setCollateralisationCategory(CollateralisationType3Code _collateralisationCategory) {
			this.collateralisationCategory = _collateralisationCategory == null ? null : _collateralisationCategory;
			return this;
		}
		
		@Override
		public CollateralDetails build() {
			return new CollateralDetails.CollateralDetailsImpl(this);
		}
		
		@Override
		public CollateralDetails.CollateralDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralDetails.CollateralDetailsBuilder prune() {
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			if (uniqueTradeIdentifier!=null && !uniqueTradeIdentifier.prune().hasData()) uniqueTradeIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralTimestamp()!=null) return true;
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			if (getUniqueTradeIdentifier()!=null && getUniqueTradeIdentifier().hasData()) return true;
			if (getAction()!=null) return true;
			if (getCollateralisationCategory()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralDetails.CollateralDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralDetails.CollateralDetailsBuilder o = (CollateralDetails.CollateralDetailsBuilder) other;
			
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			merger.mergeRosetta(getUniqueTradeIdentifier(), o.getUniqueTradeIdentifier(), this::setUniqueTradeIdentifier);
			
			merger.mergeBasic(getCollateralTimestamp(), o.getCollateralTimestamp(), this::setCollateralTimestamp);
			merger.mergeBasic(getAction(), o.getAction(), this::setAction);
			merger.mergeBasic(getCollateralisationCategory(), o.getCollateralisationCategory(), this::setCollateralisationCategory);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralDetails _that = getType().cast(o);
		
			if (!Objects.equals(collateralTimestamp, _that.getCollateralTimestamp())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(uniqueTradeIdentifier, _that.getUniqueTradeIdentifier())) return false;
			if (!Objects.equals(action, _that.getAction())) return false;
			if (!Objects.equals(collateralisationCategory, _that.getCollateralisationCategory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralTimestamp != null ? collateralTimestamp.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (uniqueTradeIdentifier != null ? uniqueTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (action != null ? action.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (collateralisationCategory != null ? collateralisationCategory.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralDetailsBuilder {" +
				"collateralTimestamp=" + this.collateralTimestamp + ", " +
				"collateral=" + this.collateral + ", " +
				"uniqueTradeIdentifier=" + this.uniqueTradeIdentifier + ", " +
				"action=" + this.action + ", " +
				"collateralisationCategory=" + this.collateralisationCategory +
			'}';
		}
	}
}
