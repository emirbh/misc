package fpml.consolidated.reg.fpmlreporting.product;

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
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductSizesMeta;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductSizes", builder=RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductSizes", model="fpml", builder=RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductSizes extends RosettaModelObject {

	RegulatoryReportingProductSizesMeta metaData = new RegulatoryReportingProductSizesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends NonNegativeMoney> getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	NonNegativeMoney getCallAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	NonNegativeMoney getPutAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends NonNegativeAmountSchedule> getNotionalSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<BigDecimal> getQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<BigDecimal> getQuantityFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	CommodityPhysicalQuantitySchedule getQuantitySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<BigDecimal> getTotalNotionalQuantity();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductSizes build();
	
	RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder toBuilder();
	
	static RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder builder() {
		return new RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductSizes> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductSizes> getType() {
		return RegulatoryReportingProductSizes.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("callAmount"), processor, NonNegativeMoney.class, getCallAmount());
		processRosetta(path.newSubPath("putAmount"), processor, NonNegativeMoney.class, getPutAmount());
		processRosetta(path.newSubPath("notionalSchedule"), processor, NonNegativeAmountSchedule.class, getNotionalSchedule());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("quantityFrequency"), BigDecimal.class, getQuantityFrequency(), this);
		processRosetta(path.newSubPath("quantitySchedule"), processor, CommodityPhysicalQuantitySchedule.class, getQuantitySchedule());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductSizesBuilder extends RegulatoryReportingProductSizes, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional(int index);
		@Override
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getNotional();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCallAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getCallAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePutAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPutAmount();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalSchedule(int index);
		@Override
		List<? extends NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder> getNotionalSchedule();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreateQuantitySchedule();
		@Override
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getQuantitySchedule();
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotional(NonNegativeMoney notional);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotional(NonNegativeMoney notional, int idx);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotional(List<? extends NonNegativeMoney> notional);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setNotional(List<? extends NonNegativeMoney> notional);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setCallAmount(NonNegativeMoney callAmount);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setPutAmount(NonNegativeMoney putAmount);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotionalSchedule(NonNegativeAmountSchedule notionalSchedule);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotionalSchedule(NonNegativeAmountSchedule notionalSchedule, int idx);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotionalSchedule(List<? extends NonNegativeAmountSchedule> notionalSchedule);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setNotionalSchedule(List<? extends NonNegativeAmountSchedule> notionalSchedule);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantity(BigDecimal quantity);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantity(BigDecimal quantity, int idx);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantity(List<BigDecimal> quantity);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setQuantity(List<BigDecimal> quantity);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantityFrequency(BigDecimal quantityFrequency);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantityFrequency(BigDecimal quantityFrequency, int idx);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantityFrequency(List<BigDecimal> quantityFrequency);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setQuantityFrequency(List<BigDecimal> quantityFrequency);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setQuantitySchedule(CommodityPhysicalQuantitySchedule quantitySchedule);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addTotalNotionalQuantity(BigDecimal totalNotionalQuantity, int idx);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addTotalNotionalQuantity(List<BigDecimal> totalNotionalQuantity);
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setTotalNotionalQuantity(List<BigDecimal> totalNotionalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("callAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getCallAmount());
			processRosetta(path.newSubPath("putAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPutAmount());
			processRosetta(path.newSubPath("notionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalSchedule());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("quantityFrequency"), BigDecimal.class, getQuantityFrequency(), this);
			processRosetta(path.newSubPath("quantitySchedule"), processor, CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder.class, getQuantitySchedule());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		}
		

		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductSizes  ***********************/
	class RegulatoryReportingProductSizesImpl implements RegulatoryReportingProductSizes {
		private final List<? extends NonNegativeMoney> notional;
		private final NonNegativeMoney callAmount;
		private final NonNegativeMoney putAmount;
		private final List<? extends NonNegativeAmountSchedule> notionalSchedule;
		private final List<BigDecimal> quantity;
		private final List<BigDecimal> quantityFrequency;
		private final CommodityPhysicalQuantitySchedule quantitySchedule;
		private final List<BigDecimal> totalNotionalQuantity;
		
		protected RegulatoryReportingProductSizesImpl(RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder builder) {
			this.notional = ofNullable(builder.getNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.callAmount = ofNullable(builder.getCallAmount()).map(f->f.build()).orElse(null);
			this.putAmount = ofNullable(builder.getPutAmount()).map(f->f.build()).orElse(null);
			this.notionalSchedule = ofNullable(builder.getNotionalSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.quantityFrequency = ofNullable(builder.getQuantityFrequency()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.quantitySchedule = ofNullable(builder.getQuantitySchedule()).map(f->f.build()).orElse(null);
			this.totalNotionalQuantity = ofNullable(builder.getTotalNotionalQuantity()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notional")
		public List<? extends NonNegativeMoney> getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callAmount")
		public NonNegativeMoney getCallAmount() {
			return callAmount;
		}
		
		@Override
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putAmount")
		public NonNegativeMoney getPutAmount() {
			return putAmount;
		}
		
		@Override
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalSchedule")
		public List<? extends NonNegativeAmountSchedule> getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantity")
		public List<BigDecimal> getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantityFrequency")
		public List<BigDecimal> getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("quantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantitySchedule")
		public CommodityPhysicalQuantitySchedule getQuantitySchedule() {
			return quantitySchedule;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("totalNotionalQuantity")
		public List<BigDecimal> getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		public RegulatoryReportingProductSizes build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder toBuilder() {
			RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder builder) {
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getCallAmount()).ifPresent(builder::setCallAmount);
			ofNullable(getPutAmount()).ifPresent(builder::setPutAmount);
			ofNullable(getNotionalSchedule()).ifPresent(builder::setNotionalSchedule);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getQuantityFrequency()).ifPresent(builder::setQuantityFrequency);
			ofNullable(getQuantitySchedule()).ifPresent(builder::setQuantitySchedule);
			ofNullable(getTotalNotionalQuantity()).ifPresent(builder::setTotalNotionalQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductSizes _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notional, _that.getNotional())) return false;
			if (!Objects.equals(callAmount, _that.getCallAmount())) return false;
			if (!Objects.equals(putAmount, _that.getPutAmount())) return false;
			if (!ListEquals.listEquals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(quantitySchedule, _that.getQuantitySchedule())) return false;
			if (!ListEquals.listEquals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (callAmount != null ? callAmount.hashCode() : 0);
			_result = 31 * _result + (putAmount != null ? putAmount.hashCode() : 0);
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (quantitySchedule != null ? quantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductSizes {" +
				"notional=" + this.notional + ", " +
				"callAmount=" + this.callAmount + ", " +
				"putAmount=" + this.putAmount + ", " +
				"notionalSchedule=" + this.notionalSchedule + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"quantitySchedule=" + this.quantitySchedule + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductSizes  ***********************/
	class RegulatoryReportingProductSizesBuilderImpl implements RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder {
	
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> notional = new ArrayList<>();
		protected NonNegativeMoney.NonNegativeMoneyBuilder callAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder putAmount;
		protected List<NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder> notionalSchedule = new ArrayList<>();
		protected List<BigDecimal> quantity = new ArrayList<>();
		protected List<BigDecimal> quantityFrequency = new ArrayList<>();
		protected CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder quantitySchedule;
		protected List<BigDecimal> totalNotionalQuantity = new ArrayList<>();
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notional")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getNotional() {
			return notional;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional(int index) {
			if (notional==null) {
				this.notional = new ArrayList<>();
			}
			return getIndex(notional, index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newNotional = NonNegativeMoney.builder();
						return newNotional;
					});
		}
		
		@Override
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getCallAmount() {
			return callAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCallAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (callAmount!=null) {
				result = callAmount;
			}
			else {
				result = callAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPutAmount() {
			return putAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePutAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (putAmount!=null) {
				result = putAmount;
			}
			else {
				result = putAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalSchedule")
		public List<? extends NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder> getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalSchedule(int index) {
			if (notionalSchedule==null) {
				this.notionalSchedule = new ArrayList<>();
			}
			return getIndex(notionalSchedule, index, () -> {
						NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder newNotionalSchedule = NonNegativeAmountSchedule.builder();
						return newNotionalSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantity")
		public List<BigDecimal> getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantityFrequency")
		public List<BigDecimal> getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("quantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantitySchedule")
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getQuantitySchedule() {
			return quantitySchedule;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreateQuantitySchedule() {
			CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder result;
			if (quantitySchedule!=null) {
				result = quantitySchedule;
			}
			else {
				result = quantitySchedule = CommodityPhysicalQuantitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("totalNotionalQuantity")
		public List<BigDecimal> getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notional")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotional(NonNegativeMoney _notional) {
			if (_notional != null) {
				this.notional.add(_notional.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotional(NonNegativeMoney _notional, int idx) {
			getIndex(this.notional, idx, () -> _notional.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotional(List<? extends NonNegativeMoney> notionals) {
			if (notionals != null) {
				for (final NonNegativeMoney toAdd : notionals) {
					this.notional.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notional")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setNotional(List<? extends NonNegativeMoney> notionals) {
			if (notionals == null) {
				this.notional = new ArrayList<>();
			} else {
				this.notional = notionals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setCallAmount(NonNegativeMoney _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setPutAmount(NonNegativeMoney _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalSchedule")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotionalSchedule(NonNegativeAmountSchedule _notionalSchedule) {
			if (_notionalSchedule != null) {
				this.notionalSchedule.add(_notionalSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotionalSchedule(NonNegativeAmountSchedule _notionalSchedule, int idx) {
			getIndex(this.notionalSchedule, idx, () -> _notionalSchedule.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addNotionalSchedule(List<? extends NonNegativeAmountSchedule> notionalSchedules) {
			if (notionalSchedules != null) {
				for (final NonNegativeAmountSchedule toAdd : notionalSchedules) {
					this.notionalSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notionalSchedule")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setNotionalSchedule(List<? extends NonNegativeAmountSchedule> notionalSchedules) {
			if (notionalSchedules == null) {
				this.notionalSchedule = new ArrayList<>();
			} else {
				this.notionalSchedule = notionalSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quantity")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantity(BigDecimal _quantity) {
			if (_quantity != null) {
				this.quantity.add(_quantity);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantity(BigDecimal _quantity, int idx) {
			getIndex(this.quantity, idx, () -> _quantity);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantity(List<BigDecimal> quantitys) {
			if (quantitys != null) {
				for (final BigDecimal toAdd : quantitys) {
					this.quantity.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quantity")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setQuantity(List<BigDecimal> quantitys) {
			if (quantitys == null) {
				this.quantity = new ArrayList<>();
			} else {
				this.quantity = quantitys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quantityFrequency")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantityFrequency(BigDecimal _quantityFrequency) {
			if (_quantityFrequency != null) {
				this.quantityFrequency.add(_quantityFrequency);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantityFrequency(BigDecimal _quantityFrequency, int idx) {
			getIndex(this.quantityFrequency, idx, () -> _quantityFrequency);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addQuantityFrequency(List<BigDecimal> quantityFrequencys) {
			if (quantityFrequencys != null) {
				for (final BigDecimal toAdd : quantityFrequencys) {
					this.quantityFrequency.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quantityFrequency")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setQuantityFrequency(List<BigDecimal> quantityFrequencys) {
			if (quantityFrequencys == null) {
				this.quantityFrequency = new ArrayList<>();
			} else {
				this.quantityFrequency = quantityFrequencys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("quantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantitySchedule")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setQuantitySchedule(CommodityPhysicalQuantitySchedule _quantitySchedule) {
			this.quantitySchedule = _quantitySchedule == null ? null : _quantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			if (_totalNotionalQuantity != null) {
				this.totalNotionalQuantity.add(_totalNotionalQuantity);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addTotalNotionalQuantity(BigDecimal _totalNotionalQuantity, int idx) {
			getIndex(this.totalNotionalQuantity, idx, () -> _totalNotionalQuantity);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder addTotalNotionalQuantity(List<BigDecimal> totalNotionalQuantitys) {
			if (totalNotionalQuantitys != null) {
				for (final BigDecimal toAdd : totalNotionalQuantitys) {
					this.totalNotionalQuantity.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder setTotalNotionalQuantity(List<BigDecimal> totalNotionalQuantitys) {
			if (totalNotionalQuantitys == null) {
				this.totalNotionalQuantity = new ArrayList<>();
			} else {
				this.totalNotionalQuantity = totalNotionalQuantitys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSizes build() {
			return new RegulatoryReportingProductSizes.RegulatoryReportingProductSizesImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder prune() {
			notional = notional.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (callAmount!=null && !callAmount.prune().hasData()) callAmount = null;
			if (putAmount!=null && !putAmount.prune().hasData()) putAmount = null;
			notionalSchedule = notionalSchedule.stream().filter(b->b!=null).<NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (quantitySchedule!=null && !quantitySchedule.prune().hasData()) quantitySchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotional()!=null && getNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCallAmount()!=null && getCallAmount().hasData()) return true;
			if (getPutAmount()!=null && getPutAmount().hasData()) return true;
			if (getNotionalSchedule()!=null && getNotionalSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getQuantity()!=null && !getQuantity().isEmpty()) return true;
			if (getQuantityFrequency()!=null && !getQuantityFrequency().isEmpty()) return true;
			if (getQuantitySchedule()!=null && getQuantitySchedule().hasData()) return true;
			if (getTotalNotionalQuantity()!=null && !getTotalNotionalQuantity().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder o = (RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder) other;
			
			merger.mergeRosetta(getNotional(), o.getNotional(), this::getOrCreateNotional);
			merger.mergeRosetta(getCallAmount(), o.getCallAmount(), this::setCallAmount);
			merger.mergeRosetta(getPutAmount(), o.getPutAmount(), this::setPutAmount);
			merger.mergeRosetta(getNotionalSchedule(), o.getNotionalSchedule(), this::getOrCreateNotionalSchedule);
			merger.mergeRosetta(getQuantitySchedule(), o.getQuantitySchedule(), this::setQuantitySchedule);
			
			merger.mergeBasic(getQuantity(), o.getQuantity(), (Consumer<BigDecimal>) this::addQuantity);
			merger.mergeBasic(getQuantityFrequency(), o.getQuantityFrequency(), (Consumer<BigDecimal>) this::addQuantityFrequency);
			merger.mergeBasic(getTotalNotionalQuantity(), o.getTotalNotionalQuantity(), (Consumer<BigDecimal>) this::addTotalNotionalQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductSizes _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notional, _that.getNotional())) return false;
			if (!Objects.equals(callAmount, _that.getCallAmount())) return false;
			if (!Objects.equals(putAmount, _that.getPutAmount())) return false;
			if (!ListEquals.listEquals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(quantitySchedule, _that.getQuantitySchedule())) return false;
			if (!ListEquals.listEquals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (callAmount != null ? callAmount.hashCode() : 0);
			_result = 31 * _result + (putAmount != null ? putAmount.hashCode() : 0);
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (quantitySchedule != null ? quantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductSizesBuilder {" +
				"notional=" + this.notional + ", " +
				"callAmount=" + this.callAmount + ", " +
				"putAmount=" + this.putAmount + ", " +
				"notionalSchedule=" + this.notionalSchedule + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"quantitySchedule=" + this.quantitySchedule + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity +
			'}';
		}
	}
}
