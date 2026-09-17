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
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductDatesMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
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
 * Provision Date related fields. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductDates", builder=RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductDates", model="fpml", builder=RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductDates extends RosettaModelObject {

	RegulatoryReportingProductDatesMeta metaData = new RegulatoryReportingProductDatesMeta();

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
	List<ZonedDateTime> getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<ZonedDateTime> getContractExpirationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<ZonedDateTime> getFinalContractualSettlementDate();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductDates build();
	
	RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder toBuilder();
	
	static RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder builder() {
		return new RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductDates> getType() {
		return RegulatoryReportingProductDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("contractExpirationDate"), ZonedDateTime.class, getContractExpirationDate(), this);
		processor.processBasic(path.newSubPath("finalContractualSettlementDate"), ZonedDateTime.class, getFinalContractualSettlementDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductDatesBuilder extends RegulatoryReportingProductDates, RosettaModelObjectBuilder {
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addEffectiveDate(ZonedDateTime effectiveDate);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addEffectiveDate(ZonedDateTime effectiveDate, int idx);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addEffectiveDate(List<ZonedDateTime> effectiveDate);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder setEffectiveDate(List<ZonedDateTime> effectiveDate);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addContractExpirationDate(ZonedDateTime contractExpirationDate);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addContractExpirationDate(ZonedDateTime contractExpirationDate, int idx);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addContractExpirationDate(List<ZonedDateTime> contractExpirationDate);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder setContractExpirationDate(List<ZonedDateTime> contractExpirationDate);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addFinalContractualSettlementDate(ZonedDateTime finalContractualSettlementDate);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addFinalContractualSettlementDate(ZonedDateTime finalContractualSettlementDate, int idx);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addFinalContractualSettlementDate(List<ZonedDateTime> finalContractualSettlementDate);
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder setFinalContractualSettlementDate(List<ZonedDateTime> finalContractualSettlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("contractExpirationDate"), ZonedDateTime.class, getContractExpirationDate(), this);
			processor.processBasic(path.newSubPath("finalContractualSettlementDate"), ZonedDateTime.class, getFinalContractualSettlementDate(), this);
		}
		

		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductDates  ***********************/
	class RegulatoryReportingProductDatesImpl implements RegulatoryReportingProductDates {
		private final List<ZonedDateTime> effectiveDate;
		private final List<ZonedDateTime> contractExpirationDate;
		private final List<ZonedDateTime> finalContractualSettlementDate;
		
		protected RegulatoryReportingProductDatesImpl(RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.contractExpirationDate = ofNullable(builder.getContractExpirationDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.finalContractualSettlementDate = ofNullable(builder.getFinalContractualSettlementDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("effectiveDate")
		public List<ZonedDateTime> getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("contractExpirationDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractExpirationDate")
		public List<ZonedDateTime> getContractExpirationDate() {
			return contractExpirationDate;
		}
		
		@Override
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("finalContractualSettlementDate")
		public List<ZonedDateTime> getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@Override
		public RegulatoryReportingProductDates build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder toBuilder() {
			RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getContractExpirationDate()).ifPresent(builder::setContractExpirationDate);
			ofNullable(getFinalContractualSettlementDate()).ifPresent(builder::setFinalContractualSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(contractExpirationDate, _that.getContractExpirationDate())) return false;
			if (!ListEquals.listEquals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (contractExpirationDate != null ? contractExpirationDate.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductDates {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"contractExpirationDate=" + this.contractExpirationDate + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductDates  ***********************/
	class RegulatoryReportingProductDatesBuilderImpl implements RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder {
	
		protected List<ZonedDateTime> effectiveDate = new ArrayList<>();
		protected List<ZonedDateTime> contractExpirationDate = new ArrayList<>();
		protected List<ZonedDateTime> finalContractualSettlementDate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("effectiveDate")
		public List<ZonedDateTime> getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("contractExpirationDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractExpirationDate")
		public List<ZonedDateTime> getContractExpirationDate() {
			return contractExpirationDate;
		}
		
		@Override
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("finalContractualSettlementDate")
		public List<ZonedDateTime> getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("effectiveDate")
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addEffectiveDate(ZonedDateTime _effectiveDate) {
			if (_effectiveDate != null) {
				this.effectiveDate.add(_effectiveDate);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addEffectiveDate(ZonedDateTime _effectiveDate, int idx) {
			getIndex(this.effectiveDate, idx, () -> _effectiveDate);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addEffectiveDate(List<ZonedDateTime> effectiveDates) {
			if (effectiveDates != null) {
				for (final ZonedDateTime toAdd : effectiveDates) {
					this.effectiveDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("effectiveDate")
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder setEffectiveDate(List<ZonedDateTime> effectiveDates) {
			if (effectiveDates == null) {
				this.effectiveDate = new ArrayList<>();
			} else {
				this.effectiveDate = effectiveDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("contractExpirationDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractExpirationDate")
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addContractExpirationDate(ZonedDateTime _contractExpirationDate) {
			if (_contractExpirationDate != null) {
				this.contractExpirationDate.add(_contractExpirationDate);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addContractExpirationDate(ZonedDateTime _contractExpirationDate, int idx) {
			getIndex(this.contractExpirationDate, idx, () -> _contractExpirationDate);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addContractExpirationDate(List<ZonedDateTime> contractExpirationDates) {
			if (contractExpirationDates != null) {
				for (final ZonedDateTime toAdd : contractExpirationDates) {
					this.contractExpirationDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("contractExpirationDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contractExpirationDate")
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder setContractExpirationDate(List<ZonedDateTime> contractExpirationDates) {
			if (contractExpirationDates == null) {
				this.contractExpirationDate = new ArrayList<>();
			} else {
				this.contractExpirationDate = contractExpirationDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addFinalContractualSettlementDate(ZonedDateTime _finalContractualSettlementDate) {
			if (_finalContractualSettlementDate != null) {
				this.finalContractualSettlementDate.add(_finalContractualSettlementDate);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addFinalContractualSettlementDate(ZonedDateTime _finalContractualSettlementDate, int idx) {
			getIndex(this.finalContractualSettlementDate, idx, () -> _finalContractualSettlementDate);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder addFinalContractualSettlementDate(List<ZonedDateTime> finalContractualSettlementDates) {
			if (finalContractualSettlementDates != null) {
				for (final ZonedDateTime toAdd : finalContractualSettlementDates) {
					this.finalContractualSettlementDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder setFinalContractualSettlementDate(List<ZonedDateTime> finalContractualSettlementDates) {
			if (finalContractualSettlementDates == null) {
				this.finalContractualSettlementDate = new ArrayList<>();
			} else {
				this.finalContractualSettlementDate = finalContractualSettlementDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductDates build() {
			return new RegulatoryReportingProductDates.RegulatoryReportingProductDatesImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && !getEffectiveDate().isEmpty()) return true;
			if (getContractExpirationDate()!=null && !getContractExpirationDate().isEmpty()) return true;
			if (getFinalContractualSettlementDate()!=null && !getFinalContractualSettlementDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder o = (RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder) other;
			
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), (Consumer<ZonedDateTime>) this::addEffectiveDate);
			merger.mergeBasic(getContractExpirationDate(), o.getContractExpirationDate(), (Consumer<ZonedDateTime>) this::addContractExpirationDate);
			merger.mergeBasic(getFinalContractualSettlementDate(), o.getFinalContractualSettlementDate(), (Consumer<ZonedDateTime>) this::addFinalContractualSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(contractExpirationDate, _that.getContractExpirationDate())) return false;
			if (!ListEquals.listEquals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (contractExpirationDate != null ? contractExpirationDate.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductDatesBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"contractExpirationDate=" + this.contractExpirationDate + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate +
			'}';
		}
	}
}
