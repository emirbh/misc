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
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
import fpml.consolidated.generic.GenericCommodityDeliveryPeriod;
import fpml.consolidated.generic.GenericCommodityGrade;
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingNonCDEProductCommodityDetailsMeta;
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
 * Provision Commodity product data fields not called out in CPMI-IOSCO CDE. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingNonCDEProductCommodityDetails", builder=RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingNonCDEProductCommodityDetails", model="fpml", builder=RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingNonCDEProductCommodityDetails extends RosettaModelObject {

	RegulatoryReportingNonCDEProductCommodityDetailsMeta metaData = new RegulatoryReportingNonCDEProductCommodityDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The grade(s) of material which can be delivered in seller's option.
	 *
	 */
	List<? extends GenericCommodityGrade> getGrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the delivery time periods (normally used for electricity swaps).
	 *
	 */
	List<? extends GenericCommodityDeliveryPeriod> getSettlementPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision LoadType is a summary of the full description of the settlement periods with respect to the region. Used for describing Electricity delivery schedules (e.g. Base, Peak, Off-Peak, Custom).
	 *
	 */
	LoadTypeEnum getLoadType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The periodic quantity. Used in conjunction with the quantityFrequency to define quantity per period.
	 *
	 */
	BigDecimal getQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
	 *
	 */
	CommodityQuantityFrequency getQuantityFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fixed price on which fixed payments are based.
	 *
	 */
	CommodityFixedPrice getFixedPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the border(s) or border point(s) of a transportation contract.
	 *
	 */
	InterconnectionPoint getInterconnectionPoint();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingNonCDEProductCommodityDetails build();
	
	RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder toBuilder();
	
	static RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder builder() {
		return new RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingNonCDEProductCommodityDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingNonCDEProductCommodityDetails> getType() {
		return RegulatoryReportingNonCDEProductCommodityDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("grade"), processor, GenericCommodityGrade.class, getGrade());
		processRosetta(path.newSubPath("settlementPeriods"), processor, GenericCommodityDeliveryPeriod.class, getSettlementPeriods());
		processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.class, getQuantityFrequency());
		processRosetta(path.newSubPath("fixedPrice"), processor, CommodityFixedPrice.class, getFixedPrice());
		processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.class, getInterconnectionPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingNonCDEProductCommodityDetailsBuilder extends RegulatoryReportingNonCDEProductCommodityDetails, RosettaModelObjectBuilder {
		GenericCommodityGrade.GenericCommodityGradeBuilder getOrCreateGrade(int index);
		@Override
		List<? extends GenericCommodityGrade.GenericCommodityGradeBuilder> getGrade();
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder getOrCreateSettlementPeriods(int index);
		@Override
		List<? extends GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> getSettlementPeriods();
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency();
		@Override
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency();
		CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateFixedPrice();
		@Override
		CommodityFixedPrice.CommodityFixedPriceBuilder getFixedPrice();
		InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint();
		@Override
		InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint();
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addGrade(GenericCommodityGrade grade);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addGrade(GenericCommodityGrade grade, int idx);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addGrade(List<? extends GenericCommodityGrade> grade);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setGrade(List<? extends GenericCommodityGrade> grade);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod settlementPeriods);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod settlementPeriods, int idx);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriods);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriods);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setLoadType(LoadTypeEnum loadType);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setQuantity(BigDecimal quantity);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setFixedPrice(CommodityFixedPrice fixedPrice);
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setInterconnectionPoint(InterconnectionPoint interconnectionPoint);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("grade"), processor, GenericCommodityGrade.GenericCommodityGradeBuilder.class, getGrade());
			processRosetta(path.newSubPath("settlementPeriods"), processor, GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder.class, getSettlementPeriods());
			processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder.class, getQuantityFrequency());
			processRosetta(path.newSubPath("fixedPrice"), processor, CommodityFixedPrice.CommodityFixedPriceBuilder.class, getFixedPrice());
			processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.InterconnectionPointBuilder.class, getInterconnectionPoint());
		}
		

		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingNonCDEProductCommodityDetails  ***********************/
	class RegulatoryReportingNonCDEProductCommodityDetailsImpl implements RegulatoryReportingNonCDEProductCommodityDetails {
		private final List<? extends GenericCommodityGrade> grade;
		private final List<? extends GenericCommodityDeliveryPeriod> settlementPeriods;
		private final LoadTypeEnum loadType;
		private final BigDecimal quantity;
		private final CommodityQuantityFrequency quantityFrequency;
		private final CommodityFixedPrice fixedPrice;
		private final InterconnectionPoint interconnectionPoint;
		
		protected RegulatoryReportingNonCDEProductCommodityDetailsImpl(RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder builder) {
			this.grade = ofNullable(builder.getGrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriods = ofNullable(builder.getSettlementPeriods()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loadType = builder.getLoadType();
			this.quantity = builder.getQuantity();
			this.quantityFrequency = ofNullable(builder.getQuantityFrequency()).map(f->f.build()).orElse(null);
			this.fixedPrice = ofNullable(builder.getFixedPrice()).map(f->f.build()).orElse(null);
			this.interconnectionPoint = ofNullable(builder.getInterconnectionPoint()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("grade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("grade")
		public List<? extends GenericCommodityGrade> getGrade() {
			return grade;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		public List<? extends GenericCommodityDeliveryPeriod> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequency")
		public CommodityQuantityFrequency getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPrice")
		public CommodityFixedPrice getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public InterconnectionPoint getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder toBuilder() {
			RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder builder) {
			ofNullable(getGrade()).ifPresent(builder::setGrade);
			ofNullable(getSettlementPeriods()).ifPresent(builder::setSettlementPeriods);
			ofNullable(getLoadType()).ifPresent(builder::setLoadType);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getQuantityFrequency()).ifPresent(builder::setQuantityFrequency);
			ofNullable(getFixedPrice()).ifPresent(builder::setFixedPrice);
			ofNullable(getInterconnectionPoint()).ifPresent(builder::setInterconnectionPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingNonCDEProductCommodityDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(grade, _that.getGrade())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingNonCDEProductCommodityDetails {" +
				"grade=" + this.grade + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"loadType=" + this.loadType + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"interconnectionPoint=" + this.interconnectionPoint +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingNonCDEProductCommodityDetails  ***********************/
	class RegulatoryReportingNonCDEProductCommodityDetailsBuilderImpl implements RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder {
	
		protected List<GenericCommodityGrade.GenericCommodityGradeBuilder> grade = new ArrayList<>();
		protected List<GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> settlementPeriods = new ArrayList<>();
		protected LoadTypeEnum loadType;
		protected BigDecimal quantity;
		protected CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder quantityFrequency;
		protected CommodityFixedPrice.CommodityFixedPriceBuilder fixedPrice;
		protected InterconnectionPoint.InterconnectionPointBuilder interconnectionPoint;
		
		@Override
		@RosettaAttribute("grade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("grade")
		public List<? extends GenericCommodityGrade.GenericCommodityGradeBuilder> getGrade() {
			return grade;
		}
		
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder getOrCreateGrade(int index) {
			if (grade==null) {
				this.grade = new ArrayList<>();
			}
			return getIndex(grade, index, () -> {
						GenericCommodityGrade.GenericCommodityGradeBuilder newGrade = GenericCommodityGrade.builder();
						return newGrade;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		public List<? extends GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder getOrCreateSettlementPeriods(int index) {
			if (settlementPeriods==null) {
				this.settlementPeriods = new ArrayList<>();
			}
			return getIndex(settlementPeriods, index, () -> {
						GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder newSettlementPeriods = GenericCommodityDeliveryPeriod.builder();
						return newSettlementPeriods;
					});
		}
		
		@Override
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequency")
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency() {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder result;
			if (quantityFrequency!=null) {
				result = quantityFrequency;
			}
			else {
				result = quantityFrequency = CommodityQuantityFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPrice")
		public CommodityFixedPrice.CommodityFixedPriceBuilder getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateFixedPrice() {
			CommodityFixedPrice.CommodityFixedPriceBuilder result;
			if (fixedPrice!=null) {
				result = fixedPrice;
			}
			else {
				result = fixedPrice = CommodityFixedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint() {
			InterconnectionPoint.InterconnectionPointBuilder result;
			if (interconnectionPoint!=null) {
				result = interconnectionPoint;
			}
			else {
				result = interconnectionPoint = InterconnectionPoint.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("grade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("grade")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addGrade(GenericCommodityGrade _grade) {
			if (_grade != null) {
				this.grade.add(_grade.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addGrade(GenericCommodityGrade _grade, int idx) {
			getIndex(this.grade, idx, () -> _grade.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addGrade(List<? extends GenericCommodityGrade> grades) {
			if (grades != null) {
				for (final GenericCommodityGrade toAdd : grades) {
					this.grade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("grade")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("grade")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setGrade(List<? extends GenericCommodityGrade> grades) {
			if (grades == null) {
				this.grade = new ArrayList<>();
			} else {
				this.grade = grades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriods")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod _settlementPeriods) {
			if (_settlementPeriods != null) {
				this.settlementPeriods.add(_settlementPeriods.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod _settlementPeriods, int idx) {
			getIndex(this.settlementPeriods, idx, () -> _settlementPeriods.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder addSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriodss) {
			if (settlementPeriodss != null) {
				for (final GenericCommodityDeliveryPeriod toAdd : settlementPeriodss) {
					this.settlementPeriods.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriodss) {
			if (settlementPeriodss == null) {
				this.settlementPeriods = new ArrayList<>();
			} else {
				this.settlementPeriods = settlementPeriodss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loadType")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setLoadType(LoadTypeEnum _loadType) {
			this.loadType = _loadType == null ? null : _loadType;
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantity")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequency")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setQuantityFrequency(CommodityQuantityFrequency _quantityFrequency) {
			this.quantityFrequency = _quantityFrequency == null ? null : _quantityFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedPrice")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setFixedPrice(CommodityFixedPrice _fixedPrice) {
			this.fixedPrice = _fixedPrice == null ? null : _fixedPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interconnectionPoint")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder setInterconnectionPoint(InterconnectionPoint _interconnectionPoint) {
			this.interconnectionPoint = _interconnectionPoint == null ? null : _interconnectionPoint.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails build() {
			return new RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsImpl(this);
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder prune() {
			grade = grade.stream().filter(b->b!=null).<GenericCommodityGrade.GenericCommodityGradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriods = settlementPeriods.stream().filter(b->b!=null).<GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (quantityFrequency!=null && !quantityFrequency.prune().hasData()) quantityFrequency = null;
			if (fixedPrice!=null && !fixedPrice.prune().hasData()) fixedPrice = null;
			if (interconnectionPoint!=null && !interconnectionPoint.prune().hasData()) interconnectionPoint = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGrade()!=null && getGrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriods()!=null && getSettlementPeriods().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoadType()!=null) return true;
			if (getQuantity()!=null) return true;
			if (getQuantityFrequency()!=null && getQuantityFrequency().hasData()) return true;
			if (getFixedPrice()!=null && getFixedPrice().hasData()) return true;
			if (getInterconnectionPoint()!=null && getInterconnectionPoint().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder o = (RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder) other;
			
			merger.mergeRosetta(getGrade(), o.getGrade(), this::getOrCreateGrade);
			merger.mergeRosetta(getSettlementPeriods(), o.getSettlementPeriods(), this::getOrCreateSettlementPeriods);
			merger.mergeRosetta(getQuantityFrequency(), o.getQuantityFrequency(), this::setQuantityFrequency);
			merger.mergeRosetta(getFixedPrice(), o.getFixedPrice(), this::setFixedPrice);
			merger.mergeRosetta(getInterconnectionPoint(), o.getInterconnectionPoint(), this::setInterconnectionPoint);
			
			merger.mergeBasic(getLoadType(), o.getLoadType(), this::setLoadType);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingNonCDEProductCommodityDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(grade, _that.getGrade())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingNonCDEProductCommodityDetailsBuilder {" +
				"grade=" + this.grade + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"loadType=" + this.loadType + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"interconnectionPoint=" + this.interconnectionPoint +
			'}';
		}
	}
}
