package drr.regulation.common;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.event.common.TradeIdentifier;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import drr.regulation.common.meta.ValuationTradeInformationMeta;
import drr.standards.iso.ActionTypeEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ValuationTradeInformation", builder=ValuationTradeInformation.ValuationTradeInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ValuationTradeInformation", model="drr", builder=ValuationTradeInformation.ValuationTradeInformationBuilderImpl.class, version="7.7.0")
public interface ValuationTradeInformation extends RosettaModelObject {

	ValuationTradeInformationMeta metaData = new ValuationTradeInformationMeta();

	/*********************** Getter Methods  ***********************/
	TradeIdentifier getUniqueTradeIdentifier();
	List<? extends ProductIdentifier> getUniqueProductIdentifier();
	ActionTypeEnum getAction();
	Date getNextFloatingReferenceResetDateLeg1();
	Date getNextFloatingReferenceResetDateLeg2();
	LastFloatingReference getLastFloatingReference();
	CommonAssetClass getAssetClass();

	/*********************** Build Methods  ***********************/
	ValuationTradeInformation build();
	
	ValuationTradeInformation.ValuationTradeInformationBuilder toBuilder();
	
	static ValuationTradeInformation.ValuationTradeInformationBuilder builder() {
		return new ValuationTradeInformation.ValuationTradeInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationTradeInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationTradeInformation> getType() {
		return ValuationTradeInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("uniqueTradeIdentifier"), processor, TradeIdentifier.class, getUniqueTradeIdentifier());
		processRosetta(path.newSubPath("uniqueProductIdentifier"), processor, ProductIdentifier.class, getUniqueProductIdentifier());
		processor.processBasic(path.newSubPath("action"), ActionTypeEnum.class, getAction(), this);
		processor.processBasic(path.newSubPath("nextFloatingReferenceResetDateLeg1"), Date.class, getNextFloatingReferenceResetDateLeg1(), this);
		processor.processBasic(path.newSubPath("nextFloatingReferenceResetDateLeg2"), Date.class, getNextFloatingReferenceResetDateLeg2(), this);
		processRosetta(path.newSubPath("lastFloatingReference"), processor, LastFloatingReference.class, getLastFloatingReference());
		processor.processBasic(path.newSubPath("assetClass"), CommonAssetClass.class, getAssetClass(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationTradeInformationBuilder extends ValuationTradeInformation, RosettaModelObjectBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateUniqueTradeIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getUniqueTradeIdentifier();
		ProductIdentifier.ProductIdentifierBuilder getOrCreateUniqueProductIdentifier(int index);
		@Override
		List<? extends ProductIdentifier.ProductIdentifierBuilder> getUniqueProductIdentifier();
		LastFloatingReference.LastFloatingReferenceBuilder getOrCreateLastFloatingReference();
		@Override
		LastFloatingReference.LastFloatingReferenceBuilder getLastFloatingReference();
		ValuationTradeInformation.ValuationTradeInformationBuilder setUniqueTradeIdentifier(TradeIdentifier uniqueTradeIdentifier);
		ValuationTradeInformation.ValuationTradeInformationBuilder addUniqueProductIdentifier(ProductIdentifier uniqueProductIdentifier);
		ValuationTradeInformation.ValuationTradeInformationBuilder addUniqueProductIdentifier(ProductIdentifier uniqueProductIdentifier, int idx);
		ValuationTradeInformation.ValuationTradeInformationBuilder addUniqueProductIdentifier(List<? extends ProductIdentifier> uniqueProductIdentifier);
		ValuationTradeInformation.ValuationTradeInformationBuilder setUniqueProductIdentifier(List<? extends ProductIdentifier> uniqueProductIdentifier);
		ValuationTradeInformation.ValuationTradeInformationBuilder setAction(ActionTypeEnum action);
		ValuationTradeInformation.ValuationTradeInformationBuilder setNextFloatingReferenceResetDateLeg1(Date nextFloatingReferenceResetDateLeg1);
		ValuationTradeInformation.ValuationTradeInformationBuilder setNextFloatingReferenceResetDateLeg2(Date nextFloatingReferenceResetDateLeg2);
		ValuationTradeInformation.ValuationTradeInformationBuilder setLastFloatingReference(LastFloatingReference lastFloatingReference);
		ValuationTradeInformation.ValuationTradeInformationBuilder setAssetClass(CommonAssetClass assetClass);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("uniqueTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getUniqueTradeIdentifier());
			processRosetta(path.newSubPath("uniqueProductIdentifier"), processor, ProductIdentifier.ProductIdentifierBuilder.class, getUniqueProductIdentifier());
			processor.processBasic(path.newSubPath("action"), ActionTypeEnum.class, getAction(), this);
			processor.processBasic(path.newSubPath("nextFloatingReferenceResetDateLeg1"), Date.class, getNextFloatingReferenceResetDateLeg1(), this);
			processor.processBasic(path.newSubPath("nextFloatingReferenceResetDateLeg2"), Date.class, getNextFloatingReferenceResetDateLeg2(), this);
			processRosetta(path.newSubPath("lastFloatingReference"), processor, LastFloatingReference.LastFloatingReferenceBuilder.class, getLastFloatingReference());
			processor.processBasic(path.newSubPath("assetClass"), CommonAssetClass.class, getAssetClass(), this);
		}
		

		ValuationTradeInformation.ValuationTradeInformationBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationTradeInformation  ***********************/
	class ValuationTradeInformationImpl implements ValuationTradeInformation {
		private final TradeIdentifier uniqueTradeIdentifier;
		private final List<? extends ProductIdentifier> uniqueProductIdentifier;
		private final ActionTypeEnum action;
		private final Date nextFloatingReferenceResetDateLeg1;
		private final Date nextFloatingReferenceResetDateLeg2;
		private final LastFloatingReference lastFloatingReference;
		private final CommonAssetClass assetClass;
		
		protected ValuationTradeInformationImpl(ValuationTradeInformation.ValuationTradeInformationBuilder builder) {
			this.uniqueTradeIdentifier = ofNullable(builder.getUniqueTradeIdentifier()).map(f->f.build()).orElse(null);
			this.uniqueProductIdentifier = ofNullable(builder.getUniqueProductIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.action = builder.getAction();
			this.nextFloatingReferenceResetDateLeg1 = builder.getNextFloatingReferenceResetDateLeg1();
			this.nextFloatingReferenceResetDateLeg2 = builder.getNextFloatingReferenceResetDateLeg2();
			this.lastFloatingReference = ofNullable(builder.getLastFloatingReference()).map(f->f.build()).orElse(null);
			this.assetClass = builder.getAssetClass();
		}
		
		@Override
		@RosettaAttribute("uniqueTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTradeIdentifier")
		public TradeIdentifier getUniqueTradeIdentifier() {
			return uniqueTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("uniqueProductIdentifier")
		public List<? extends ProductIdentifier> getUniqueProductIdentifier() {
			return uniqueProductIdentifier;
		}
		
		@Override
		@RosettaAttribute("action")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("action")
		public ActionTypeEnum getAction() {
			return action;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		public Date getNextFloatingReferenceResetDateLeg1() {
			return nextFloatingReferenceResetDateLeg1;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		public Date getNextFloatingReferenceResetDateLeg2() {
			return nextFloatingReferenceResetDateLeg2;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReference")
		public LastFloatingReference getLastFloatingReference() {
			return lastFloatingReference;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetClass")
		public CommonAssetClass getAssetClass() {
			return assetClass;
		}
		
		@Override
		public ValuationTradeInformation build() {
			return this;
		}
		
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder toBuilder() {
			ValuationTradeInformation.ValuationTradeInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationTradeInformation.ValuationTradeInformationBuilder builder) {
			ofNullable(getUniqueTradeIdentifier()).ifPresent(builder::setUniqueTradeIdentifier);
			ofNullable(getUniqueProductIdentifier()).ifPresent(builder::setUniqueProductIdentifier);
			ofNullable(getAction()).ifPresent(builder::setAction);
			ofNullable(getNextFloatingReferenceResetDateLeg1()).ifPresent(builder::setNextFloatingReferenceResetDateLeg1);
			ofNullable(getNextFloatingReferenceResetDateLeg2()).ifPresent(builder::setNextFloatingReferenceResetDateLeg2);
			ofNullable(getLastFloatingReference()).ifPresent(builder::setLastFloatingReference);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(uniqueTradeIdentifier, _that.getUniqueTradeIdentifier())) return false;
			if (!ListEquals.listEquals(uniqueProductIdentifier, _that.getUniqueProductIdentifier())) return false;
			if (!Objects.equals(action, _that.getAction())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDateLeg1, _that.getNextFloatingReferenceResetDateLeg1())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDateLeg2, _that.getNextFloatingReferenceResetDateLeg2())) return false;
			if (!Objects.equals(lastFloatingReference, _that.getLastFloatingReference())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uniqueTradeIdentifier != null ? uniqueTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifier != null ? uniqueProductIdentifier.hashCode() : 0);
			_result = 31 * _result + (action != null ? action.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDateLeg1 != null ? nextFloatingReferenceResetDateLeg1.hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDateLeg2 != null ? nextFloatingReferenceResetDateLeg2.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReference != null ? lastFloatingReference.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationTradeInformation {" +
				"uniqueTradeIdentifier=" + this.uniqueTradeIdentifier + ", " +
				"uniqueProductIdentifier=" + this.uniqueProductIdentifier + ", " +
				"action=" + this.action + ", " +
				"nextFloatingReferenceResetDateLeg1=" + this.nextFloatingReferenceResetDateLeg1 + ", " +
				"nextFloatingReferenceResetDateLeg2=" + this.nextFloatingReferenceResetDateLeg2 + ", " +
				"lastFloatingReference=" + this.lastFloatingReference + ", " +
				"assetClass=" + this.assetClass +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationTradeInformation  ***********************/
	class ValuationTradeInformationBuilderImpl implements ValuationTradeInformation.ValuationTradeInformationBuilder {
	
		protected TradeIdentifier.TradeIdentifierBuilder uniqueTradeIdentifier;
		protected List<ProductIdentifier.ProductIdentifierBuilder> uniqueProductIdentifier = new ArrayList<>();
		protected ActionTypeEnum action;
		protected Date nextFloatingReferenceResetDateLeg1;
		protected Date nextFloatingReferenceResetDateLeg2;
		protected LastFloatingReference.LastFloatingReferenceBuilder lastFloatingReference;
		protected CommonAssetClass assetClass;
		
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
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("uniqueProductIdentifier")
		public List<? extends ProductIdentifier.ProductIdentifierBuilder> getUniqueProductIdentifier() {
			return uniqueProductIdentifier;
		}
		
		@Override
		public ProductIdentifier.ProductIdentifierBuilder getOrCreateUniqueProductIdentifier(int index) {
			if (uniqueProductIdentifier==null) {
				this.uniqueProductIdentifier = new ArrayList<>();
			}
			return getIndex(uniqueProductIdentifier, index, () -> {
						ProductIdentifier.ProductIdentifierBuilder newUniqueProductIdentifier = ProductIdentifier.builder();
						return newUniqueProductIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("action")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("action")
		public ActionTypeEnum getAction() {
			return action;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		public Date getNextFloatingReferenceResetDateLeg1() {
			return nextFloatingReferenceResetDateLeg1;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		public Date getNextFloatingReferenceResetDateLeg2() {
			return nextFloatingReferenceResetDateLeg2;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReference")
		public LastFloatingReference.LastFloatingReferenceBuilder getLastFloatingReference() {
			return lastFloatingReference;
		}
		
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder getOrCreateLastFloatingReference() {
			LastFloatingReference.LastFloatingReferenceBuilder result;
			if (lastFloatingReference!=null) {
				result = lastFloatingReference;
			}
			else {
				result = lastFloatingReference = LastFloatingReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetClass")
		public CommonAssetClass getAssetClass() {
			return assetClass;
		}
		
		@RosettaAttribute("uniqueTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTradeIdentifier")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder setUniqueTradeIdentifier(TradeIdentifier _uniqueTradeIdentifier) {
			this.uniqueTradeIdentifier = _uniqueTradeIdentifier == null ? null : _uniqueTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder addUniqueProductIdentifier(ProductIdentifier _uniqueProductIdentifier) {
			if (_uniqueProductIdentifier != null) {
				this.uniqueProductIdentifier.add(_uniqueProductIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder addUniqueProductIdentifier(ProductIdentifier _uniqueProductIdentifier, int idx) {
			getIndex(this.uniqueProductIdentifier, idx, () -> _uniqueProductIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder addUniqueProductIdentifier(List<? extends ProductIdentifier> uniqueProductIdentifiers) {
			if (uniqueProductIdentifiers != null) {
				for (final ProductIdentifier toAdd : uniqueProductIdentifiers) {
					this.uniqueProductIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder setUniqueProductIdentifier(List<? extends ProductIdentifier> uniqueProductIdentifiers) {
			if (uniqueProductIdentifiers == null) {
				this.uniqueProductIdentifier = new ArrayList<>();
			} else {
				this.uniqueProductIdentifier = uniqueProductIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("action")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("action")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder setAction(ActionTypeEnum _action) {
			this.action = _action == null ? null : _action;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg1")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder setNextFloatingReferenceResetDateLeg1(Date _nextFloatingReferenceResetDateLeg1) {
			this.nextFloatingReferenceResetDateLeg1 = _nextFloatingReferenceResetDateLeg1 == null ? null : _nextFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDateLeg2")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder setNextFloatingReferenceResetDateLeg2(Date _nextFloatingReferenceResetDateLeg2) {
			this.nextFloatingReferenceResetDateLeg2 = _nextFloatingReferenceResetDateLeg2 == null ? null : _nextFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReference")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder setLastFloatingReference(LastFloatingReference _lastFloatingReference) {
			this.lastFloatingReference = _lastFloatingReference == null ? null : _lastFloatingReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetClass")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder setAssetClass(CommonAssetClass _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		public ValuationTradeInformation build() {
			return new ValuationTradeInformation.ValuationTradeInformationImpl(this);
		}
		
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder prune() {
			if (uniqueTradeIdentifier!=null && !uniqueTradeIdentifier.prune().hasData()) uniqueTradeIdentifier = null;
			uniqueProductIdentifier = uniqueProductIdentifier.stream().filter(b->b!=null).<ProductIdentifier.ProductIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (lastFloatingReference!=null && !lastFloatingReference.prune().hasData()) lastFloatingReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUniqueTradeIdentifier()!=null && getUniqueTradeIdentifier().hasData()) return true;
			if (getUniqueProductIdentifier()!=null && getUniqueProductIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAction()!=null) return true;
			if (getNextFloatingReferenceResetDateLeg1()!=null) return true;
			if (getNextFloatingReferenceResetDateLeg2()!=null) return true;
			if (getLastFloatingReference()!=null && getLastFloatingReference().hasData()) return true;
			if (getAssetClass()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationTradeInformation.ValuationTradeInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationTradeInformation.ValuationTradeInformationBuilder o = (ValuationTradeInformation.ValuationTradeInformationBuilder) other;
			
			merger.mergeRosetta(getUniqueTradeIdentifier(), o.getUniqueTradeIdentifier(), this::setUniqueTradeIdentifier);
			merger.mergeRosetta(getUniqueProductIdentifier(), o.getUniqueProductIdentifier(), this::getOrCreateUniqueProductIdentifier);
			merger.mergeRosetta(getLastFloatingReference(), o.getLastFloatingReference(), this::setLastFloatingReference);
			
			merger.mergeBasic(getAction(), o.getAction(), this::setAction);
			merger.mergeBasic(getNextFloatingReferenceResetDateLeg1(), o.getNextFloatingReferenceResetDateLeg1(), this::setNextFloatingReferenceResetDateLeg1);
			merger.mergeBasic(getNextFloatingReferenceResetDateLeg2(), o.getNextFloatingReferenceResetDateLeg2(), this::setNextFloatingReferenceResetDateLeg2);
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClass);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(uniqueTradeIdentifier, _that.getUniqueTradeIdentifier())) return false;
			if (!ListEquals.listEquals(uniqueProductIdentifier, _that.getUniqueProductIdentifier())) return false;
			if (!Objects.equals(action, _that.getAction())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDateLeg1, _that.getNextFloatingReferenceResetDateLeg1())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDateLeg2, _that.getNextFloatingReferenceResetDateLeg2())) return false;
			if (!Objects.equals(lastFloatingReference, _that.getLastFloatingReference())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uniqueTradeIdentifier != null ? uniqueTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifier != null ? uniqueProductIdentifier.hashCode() : 0);
			_result = 31 * _result + (action != null ? action.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDateLeg1 != null ? nextFloatingReferenceResetDateLeg1.hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDateLeg2 != null ? nextFloatingReferenceResetDateLeg2.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReference != null ? lastFloatingReference.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationTradeInformationBuilder {" +
				"uniqueTradeIdentifier=" + this.uniqueTradeIdentifier + ", " +
				"uniqueProductIdentifier=" + this.uniqueProductIdentifier + ", " +
				"action=" + this.action + ", " +
				"nextFloatingReferenceResetDateLeg1=" + this.nextFloatingReferenceResetDateLeg1 + ", " +
				"nextFloatingReferenceResetDateLeg2=" + this.nextFloatingReferenceResetDateLeg2 + ", " +
				"lastFloatingReference=" + this.lastFloatingReference + ", " +
				"assetClass=" + this.assetClass +
			'}';
		}
	}
}
