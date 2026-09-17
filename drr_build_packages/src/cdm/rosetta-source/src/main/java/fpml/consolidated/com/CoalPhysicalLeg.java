package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.meta.CoalPhysicalLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Physically settled leg of a physically settled coal transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Physically settled leg of a physically settled coal transaction.
 *
 */
@RosettaDataType(value="CoalPhysicalLeg", builder=CoalPhysicalLeg.CoalPhysicalLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalPhysicalLeg", model="fpml", builder=CoalPhysicalLeg.CoalPhysicalLegBuilderImpl.class, version="2.1.1")
public interface CoalPhysicalLeg extends PhysicalSwapLeg {

	CoalPhysicalLegMeta metaData = new CoalPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The period during which delivery/deliveries of Coal Products may be scheduled. Equivalent to Nomination Period(s) for US Coal.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The period during which delivery/deliveries of Coal Products may be scheduled. Equivalent to Nomination Period(s) for US Coal.
	 *
	 */
	CommodityDeliveryPeriods getDeliveryPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the Coal Product to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the Coal Product to be delivered.
	 *
	 */
	CoalProduct getCoal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The physical delivery conditions for the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The physical delivery conditions for the transaction.
	 *
	 */
	CoalDelivery getDeliveryConditions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The different options for specifying the quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The different options for specifying the quantity.
	 *
	 */
	CommodityPhysicalQuantity getDeliveryQuantity();

	/*********************** Build Methods  ***********************/
	CoalPhysicalLeg build();
	
	CoalPhysicalLeg.CoalPhysicalLegBuilder toBuilder();
	
	static CoalPhysicalLeg.CoalPhysicalLegBuilder builder() {
		return new CoalPhysicalLeg.CoalPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalPhysicalLeg> getType() {
		return CoalPhysicalLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("coal"), processor, CoalProduct.class, getCoal());
		processRosetta(path.newSubPath("deliveryConditions"), processor, CoalDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("deliveryQuantity"), processor, CommodityPhysicalQuantity.class, getDeliveryQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalPhysicalLegBuilder extends CoalPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		@Override
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods();
		CoalProduct.CoalProductBuilder getOrCreateCoal();
		@Override
		CoalProduct.CoalProductBuilder getCoal();
		CoalDelivery.CoalDeliveryBuilder getOrCreateDeliveryConditions();
		@Override
		CoalDelivery.CoalDeliveryBuilder getDeliveryConditions();
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getOrCreateDeliveryQuantity();
		@Override
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getDeliveryQuantity();
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder setId(String id);
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification);
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		CoalPhysicalLeg.CoalPhysicalLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setCoal(CoalProduct coal);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryConditions(CoalDelivery deliveryConditions);
		CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryQuantity(CommodityPhysicalQuantity deliveryQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("coal"), processor, CoalProduct.CoalProductBuilder.class, getCoal());
			processRosetta(path.newSubPath("deliveryConditions"), processor, CoalDelivery.CoalDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("deliveryQuantity"), processor, CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder.class, getDeliveryQuantity());
		}
		

		CoalPhysicalLeg.CoalPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of CoalPhysicalLeg  ***********************/
	class CoalPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements CoalPhysicalLeg {
		private final CommodityDeliveryPeriods deliveryPeriods;
		private final CoalProduct coal;
		private final CoalDelivery deliveryConditions;
		private final CommodityPhysicalQuantity deliveryQuantity;
		
		protected CoalPhysicalLegImpl(CoalPhysicalLeg.CoalPhysicalLegBuilder builder) {
			super(builder);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.coal = ofNullable(builder.getCoal()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.deliveryQuantity = ofNullable(builder.getDeliveryQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("coal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coal")
		public CoalProduct getCoal() {
			return coal;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryConditions")
		public CoalDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		public CommodityPhysicalQuantity getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public CoalPhysicalLeg build() {
			return this;
		}
		
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder toBuilder() {
			CoalPhysicalLeg.CoalPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalPhysicalLeg.CoalPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getCoal()).ifPresent(builder::setCoal);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getDeliveryQuantity()).ifPresent(builder::setDeliveryQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CoalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(coal, _that.getCoal())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (coal != null ? coal.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalPhysicalLeg {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"coal=" + this.coal + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CoalPhysicalLeg  ***********************/
	class CoalPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl implements CoalPhysicalLeg.CoalPhysicalLegBuilder {
	
		protected CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder deliveryPeriods;
		protected CoalProduct.CoalProductBuilder coal;
		protected CoalDelivery.CoalDeliveryBuilder deliveryConditions;
		protected CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder deliveryQuantity;
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods() {
			CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder result;
			if (deliveryPeriods!=null) {
				result = deliveryPeriods;
			}
			else {
				result = deliveryPeriods = CommodityDeliveryPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coal")
		public CoalProduct.CoalProductBuilder getCoal() {
			return coal;
		}
		
		@Override
		public CoalProduct.CoalProductBuilder getOrCreateCoal() {
			CoalProduct.CoalProductBuilder result;
			if (coal!=null) {
				result = coal;
			}
			else {
				result = coal = CoalProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryConditions")
		public CoalDelivery.CoalDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public CoalDelivery.CoalDeliveryBuilder getOrCreateDeliveryConditions() {
			CoalDelivery.CoalDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = CoalDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getOrCreateDeliveryQuantity() {
			CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder result;
			if (deliveryQuantity!=null) {
				result = deliveryQuantity;
			}
			else {
				result = deliveryQuantity = CommodityPhysicalQuantity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications != null) {
				for (final CommodityClassification toAdd : commodityClassifications) {
					this.commodityClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications == null) {
				this.commodityClassification = new ArrayList<>();
			} else {
				this.commodityClassification = commodityClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriods")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods _deliveryPeriods) {
			this.deliveryPeriods = _deliveryPeriods == null ? null : _deliveryPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coal")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("coal")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setCoal(CoalProduct _coal) {
			this.coal = _coal == null ? null : _coal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryConditions")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryConditions(CoalDelivery _deliveryConditions) {
			this.deliveryConditions = _deliveryConditions == null ? null : _deliveryConditions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder setDeliveryQuantity(CommodityPhysicalQuantity _deliveryQuantity) {
			this.deliveryQuantity = _deliveryQuantity == null ? null : _deliveryQuantity.toBuilder();
			return this;
		}
		
		@Override
		public CoalPhysicalLeg build() {
			return new CoalPhysicalLeg.CoalPhysicalLegImpl(this);
		}
		
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			if (coal!=null && !coal.prune().hasData()) coal = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (deliveryQuantity!=null && !deliveryQuantity.prune().hasData()) deliveryQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getCoal()!=null && getCoal().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getDeliveryQuantity()!=null && getDeliveryQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalPhysicalLeg.CoalPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CoalPhysicalLeg.CoalPhysicalLegBuilder o = (CoalPhysicalLeg.CoalPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getCoal(), o.getCoal(), this::setCoal);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getDeliveryQuantity(), o.getDeliveryQuantity(), this::setDeliveryQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CoalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(coal, _that.getCoal())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (coal != null ? coal.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalPhysicalLegBuilder {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"coal=" + this.coal + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}
}
