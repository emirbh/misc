package fpml.consolidated.com;

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
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.meta.CommodityBasketUnderlyingByNotionalMeta;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
import java.math.BigDecimal;
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
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CommodityBasketUnderlyingByNotional", builder=CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityBasketUnderlyingByNotional", model="fpml", builder=CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilderImpl.class, version="2.1.1")
public interface CommodityBasketUnderlyingByNotional extends CommodityBasketUnderlyingBase {

	CommodityBasketUnderlyingByNotionalMeta metaData = new CommodityBasketUnderlyingByNotionalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency.
	 *
	 */
	CommodityFx getFx();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 */
	BigDecimal getConversionFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the documentation of a shaped notional trade where the notional changes over the life of the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the documentation of a shaped notional trade where the notional changes over the life of the transaction.
	 *
	 */
	CommodityNotionalQuantitySchedule getNotionalQuantitySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Notional Quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Notional Quantity.
	 *
	 */
	CommodityNotionalQuantity getNotionalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an electricity transaction, the Notional Quantity for a one or more groups of Settlement Periods to which the Notional Quantity is based. If the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an electricity transaction, the Notional Quantity for a one or more groups of Settlement Periods to which the Notional Quantity is based. If the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 *
	 */
	List<? extends CommoditySettlementPeriodsNotionalQuantity> getSettlementPeriodsNotionalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Total Notional Quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Total Notional Quantity.
	 *
	 */
	BigDecimal getTotalNotionalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a quantity defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a quantity defined on another leg.
	 *
	 */
	QuantityReference getQuantityReference();

	/*********************** Build Methods  ***********************/
	CommodityBasketUnderlyingByNotional build();
	
	CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder toBuilder();
	
	static CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder builder() {
		return new CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketUnderlyingByNotional> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityBasketUnderlyingByNotional> getType() {
		return CommodityBasketUnderlyingByNotional.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processRosetta(path.newSubPath("fx"), processor, CommodityFx.class, getFx());
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.class, getNotionalQuantitySchedule());
		processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.class, getNotionalQuantity());
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.class, getSettlementPeriodsNotionalQuantity());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketUnderlyingByNotionalBuilder extends CommodityBasketUnderlyingByNotional, CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder {
		CommodityFx.CommodityFxBuilder getOrCreateFx();
		@Override
		CommodityFx.CommodityFxBuilder getFx();
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getOrCreateNotionalQuantitySchedule();
		@Override
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getNotionalQuantitySchedule();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity();
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder getOrCreateSettlementPeriodsNotionalQuantity(int index);
		@Override
		List<? extends CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> getSettlementPeriodsNotionalQuantity();
		QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference();
		@Override
		QuantityReference.QuantityReferenceBuilder getQuantityReference();
		@Override
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setId(String id);
		@Override
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setDirection(PayerReceiverEnum direction);
		@Override
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setCommodity(Commodity commodity);
		@Override
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setPricingDates(CommodityPricingDates pricingDates);
		@Override
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setFx(CommodityFx fx);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setConversionFactor(BigDecimal conversionFactor);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule notionalQuantitySchedule);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity, int idx);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setQuantityReference(QuantityReference quantityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processRosetta(path.newSubPath("fx"), processor, CommodityFx.CommodityFxBuilder.class, getFx());
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
			processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder.class, getNotionalQuantitySchedule());
			processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalQuantity());
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder.class, getSettlementPeriodsNotionalQuantity());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
		}
		

		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketUnderlyingByNotional  ***********************/
	class CommodityBasketUnderlyingByNotionalImpl extends CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseImpl implements CommodityBasketUnderlyingByNotional {
		private final CommodityFx fx;
		private final BigDecimal conversionFactor;
		private final CommodityNotionalQuantitySchedule notionalQuantitySchedule;
		private final CommodityNotionalQuantity notionalQuantity;
		private final List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity;
		private final BigDecimal totalNotionalQuantity;
		private final QuantityReference quantityReference;
		
		protected CommodityBasketUnderlyingByNotionalImpl(CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder builder) {
			super(builder);
			this.fx = ofNullable(builder.getFx()).map(f->f.build()).orElse(null);
			this.conversionFactor = builder.getConversionFactor();
			this.notionalQuantitySchedule = ofNullable(builder.getNotionalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.notionalQuantity = ofNullable(builder.getNotionalQuantity()).map(f->f.build()).orElse(null);
			this.settlementPeriodsNotionalQuantity = ofNullable(builder.getSettlementPeriodsNotionalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.totalNotionalQuantity = builder.getTotalNotionalQuantity();
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fx")
		public CommodityFx getFx() {
			return fx;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantitySchedule")
		public CommodityNotionalQuantitySchedule getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantity")
		public CommodityNotionalQuantity getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		public List<? extends CommoditySettlementPeriodsNotionalQuantity> getSettlementPeriodsNotionalQuantity() {
			return settlementPeriodsNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityReference")
		public QuantityReference getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional build() {
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder toBuilder() {
			CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFx()).ifPresent(builder::setFx);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
			ofNullable(getNotionalQuantitySchedule()).ifPresent(builder::setNotionalQuantitySchedule);
			ofNullable(getNotionalQuantity()).ifPresent(builder::setNotionalQuantity);
			ofNullable(getSettlementPeriodsNotionalQuantity()).ifPresent(builder::setSettlementPeriodsNotionalQuantity);
			ofNullable(getTotalNotionalQuantity()).ifPresent(builder::setTotalNotionalQuantity);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketUnderlyingByNotional _that = getType().cast(o);
		
			if (!Objects.equals(fx, _that.getFx())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantity, _that.getSettlementPeriodsNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantity != null ? settlementPeriodsNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingByNotional {" +
				"fx=" + this.fx + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"settlementPeriodsNotionalQuantity=" + this.settlementPeriodsNotionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"quantityReference=" + this.quantityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketUnderlyingByNotional  ***********************/
	class CommodityBasketUnderlyingByNotionalBuilderImpl extends CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl implements CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder {
	
		protected CommodityFx.CommodityFxBuilder fx;
		protected BigDecimal conversionFactor;
		protected CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder notionalQuantitySchedule;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder notionalQuantity;
		protected List<CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> settlementPeriodsNotionalQuantity = new ArrayList<>();
		protected BigDecimal totalNotionalQuantity;
		protected QuantityReference.QuantityReferenceBuilder quantityReference;
		
		@Override
		@RosettaAttribute("fx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fx")
		public CommodityFx.CommodityFxBuilder getFx() {
			return fx;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder getOrCreateFx() {
			CommodityFx.CommodityFxBuilder result;
			if (fx!=null) {
				result = fx;
			}
			else {
				result = fx = CommodityFx.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantitySchedule")
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getOrCreateNotionalQuantitySchedule() {
			CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder result;
			if (notionalQuantitySchedule!=null) {
				result = notionalQuantitySchedule;
			}
			else {
				result = notionalQuantitySchedule = CommodityNotionalQuantitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (notionalQuantity!=null) {
				result = notionalQuantity;
			}
			else {
				result = notionalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		public List<? extends CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> getSettlementPeriodsNotionalQuantity() {
			return settlementPeriodsNotionalQuantity;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder getOrCreateSettlementPeriodsNotionalQuantity(int index) {
			if (settlementPeriodsNotionalQuantity==null) {
				this.settlementPeriodsNotionalQuantity = new ArrayList<>();
			}
			return getIndex(settlementPeriodsNotionalQuantity, index, () -> {
						CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder newSettlementPeriodsNotionalQuantity = CommoditySettlementPeriodsNotionalQuantity.builder();
						return newSettlementPeriodsNotionalQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityReference")
		public QuantityReference.QuantityReferenceBuilder getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference() {
			QuantityReference.QuantityReferenceBuilder result;
			if (quantityReference!=null) {
				result = quantityReference;
			}
			else {
				result = quantityReference = QuantityReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("direction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setDirection(PayerReceiverEnum _direction) {
			this.direction = _direction == null ? null : _direction;
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodity")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingDates")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("fx")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fx")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setFx(CommodityFx _fx) {
			this.fx = _fx == null ? null : _fx.toBuilder();
			return this;
		}
		
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("conversionFactor")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setConversionFactor(BigDecimal _conversionFactor) {
			this.conversionFactor = _conversionFactor == null ? null : _conversionFactor;
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule _notionalQuantitySchedule) {
			this.notionalQuantitySchedule = _notionalQuantitySchedule == null ? null : _notionalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setNotionalQuantity(CommodityNotionalQuantity _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity) {
			if (_settlementPeriodsNotionalQuantity != null) {
				this.settlementPeriodsNotionalQuantity.add(_settlementPeriodsNotionalQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity, int idx) {
			getIndex(this.settlementPeriodsNotionalQuantity, idx, () -> _settlementPeriodsNotionalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
			if (settlementPeriodsNotionalQuantitys != null) {
				for (final CommoditySettlementPeriodsNotionalQuantity toAdd : settlementPeriodsNotionalQuantitys) {
					this.settlementPeriodsNotionalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
			if (settlementPeriodsNotionalQuantitys == null) {
				this.settlementPeriodsNotionalQuantity = new ArrayList<>();
			} else {
				this.settlementPeriodsNotionalQuantity = settlementPeriodsNotionalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityReference")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setQuantityReference(QuantityReference _quantityReference) {
			this.quantityReference = _quantityReference == null ? null : _quantityReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional build() {
			return new CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalImpl(this);
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder prune() {
			super.prune();
			if (fx!=null && !fx.prune().hasData()) fx = null;
			if (notionalQuantitySchedule!=null && !notionalQuantitySchedule.prune().hasData()) notionalQuantitySchedule = null;
			if (notionalQuantity!=null && !notionalQuantity.prune().hasData()) notionalQuantity = null;
			settlementPeriodsNotionalQuantity = settlementPeriodsNotionalQuantity.stream().filter(b->b!=null).<CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFx()!=null && getFx().hasData()) return true;
			if (getConversionFactor()!=null) return true;
			if (getNotionalQuantitySchedule()!=null && getNotionalQuantitySchedule().hasData()) return true;
			if (getNotionalQuantity()!=null && getNotionalQuantity().hasData()) return true;
			if (getSettlementPeriodsNotionalQuantity()!=null && getSettlementPeriodsNotionalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTotalNotionalQuantity()!=null) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder o = (CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder) other;
			
			merger.mergeRosetta(getFx(), o.getFx(), this::setFx);
			merger.mergeRosetta(getNotionalQuantitySchedule(), o.getNotionalQuantitySchedule(), this::setNotionalQuantitySchedule);
			merger.mergeRosetta(getNotionalQuantity(), o.getNotionalQuantity(), this::setNotionalQuantity);
			merger.mergeRosetta(getSettlementPeriodsNotionalQuantity(), o.getSettlementPeriodsNotionalQuantity(), this::getOrCreateSettlementPeriodsNotionalQuantity);
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			merger.mergeBasic(getTotalNotionalQuantity(), o.getTotalNotionalQuantity(), this::setTotalNotionalQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketUnderlyingByNotional _that = getType().cast(o);
		
			if (!Objects.equals(fx, _that.getFx())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantity, _that.getSettlementPeriodsNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantity != null ? settlementPeriodsNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingByNotionalBuilder {" +
				"fx=" + this.fx + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"settlementPeriodsNotionalQuantity=" + this.settlementPeriodsNotionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"quantityReference=" + this.quantityReference +
			'}' + " " + super.toString();
		}
	}
}
