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
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductCalculationTermsMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Frequency;
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
 * Provision Calculation terms. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductCalculationTerms", builder=RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductCalculationTerms", model="fpml", builder=RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductCalculationTerms extends RosettaModelObject {

	RegulatoryReportingProductCalculationTermsMeta metaData = new RegulatoryReportingProductCalculationTermsMeta();

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
	List<? extends DayCountFraction> getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends Frequency> getPaymentFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends Frequency> getCalculationFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends Frequency> getResetFrequency();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductCalculationTerms build();
	
	RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder toBuilder();
	
	static RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder builder() {
		return new RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductCalculationTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductCalculationTerms> getType() {
		return RegulatoryReportingProductCalculationTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.class, getPaymentFrequency());
		processRosetta(path.newSubPath("calculationFrequency"), processor, Frequency.class, getCalculationFrequency());
		processRosetta(path.newSubPath("resetFrequency"), processor, Frequency.class, getResetFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductCalculationTermsBuilder extends RegulatoryReportingProductCalculationTerms, RosettaModelObjectBuilder {
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction(int index);
		@Override
		List<? extends DayCountFraction.DayCountFractionBuilder> getDayCountFraction();
		Frequency.FrequencyBuilder getOrCreatePaymentFrequency(int index);
		@Override
		List<? extends Frequency.FrequencyBuilder> getPaymentFrequency();
		Frequency.FrequencyBuilder getOrCreateCalculationFrequency(int index);
		@Override
		List<? extends Frequency.FrequencyBuilder> getCalculationFrequency();
		Frequency.FrequencyBuilder getOrCreateResetFrequency(int index);
		@Override
		List<? extends Frequency.FrequencyBuilder> getResetFrequency();
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addDayCountFraction(DayCountFraction dayCountFraction);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addDayCountFraction(DayCountFraction dayCountFraction, int idx);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addDayCountFraction(List<? extends DayCountFraction> dayCountFraction);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder setDayCountFraction(List<? extends DayCountFraction> dayCountFraction);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addPaymentFrequency(Frequency paymentFrequency);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addPaymentFrequency(Frequency paymentFrequency, int idx);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addPaymentFrequency(List<? extends Frequency> paymentFrequency);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder setPaymentFrequency(List<? extends Frequency> paymentFrequency);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addCalculationFrequency(Frequency calculationFrequency);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addCalculationFrequency(Frequency calculationFrequency, int idx);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addCalculationFrequency(List<? extends Frequency> calculationFrequency);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder setCalculationFrequency(List<? extends Frequency> calculationFrequency);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addResetFrequency(Frequency resetFrequency);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addResetFrequency(Frequency resetFrequency, int idx);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addResetFrequency(List<? extends Frequency> resetFrequency);
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder setResetFrequency(List<? extends Frequency> resetFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.FrequencyBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("calculationFrequency"), processor, Frequency.FrequencyBuilder.class, getCalculationFrequency());
			processRosetta(path.newSubPath("resetFrequency"), processor, Frequency.FrequencyBuilder.class, getResetFrequency());
		}
		

		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductCalculationTerms  ***********************/
	class RegulatoryReportingProductCalculationTermsImpl implements RegulatoryReportingProductCalculationTerms {
		private final List<? extends DayCountFraction> dayCountFraction;
		private final List<? extends Frequency> paymentFrequency;
		private final List<? extends Frequency> calculationFrequency;
		private final List<? extends Frequency> resetFrequency;
		
		protected RegulatoryReportingProductCalculationTermsImpl(RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder builder) {
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationFrequency = ofNullable(builder.getCalculationFrequency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.resetFrequency = ofNullable(builder.getResetFrequency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dayCountFraction")
		public List<? extends DayCountFraction> getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentFrequency")
		public List<? extends Frequency> getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("calculationFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("calculationFrequency")
		public List<? extends Frequency> getCalculationFrequency() {
			return calculationFrequency;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("resetFrequency")
		public List<? extends Frequency> getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder toBuilder() {
			RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder builder) {
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getCalculationFrequency()).ifPresent(builder::setCalculationFrequency);
			ofNullable(getResetFrequency()).ifPresent(builder::setResetFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductCalculationTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!ListEquals.listEquals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!ListEquals.listEquals(calculationFrequency, _that.getCalculationFrequency())) return false;
			if (!ListEquals.listEquals(resetFrequency, _that.getResetFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (calculationFrequency != null ? calculationFrequency.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductCalculationTerms {" +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"calculationFrequency=" + this.calculationFrequency + ", " +
				"resetFrequency=" + this.resetFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductCalculationTerms  ***********************/
	class RegulatoryReportingProductCalculationTermsBuilderImpl implements RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder {
	
		protected List<DayCountFraction.DayCountFractionBuilder> dayCountFraction = new ArrayList<>();
		protected List<Frequency.FrequencyBuilder> paymentFrequency = new ArrayList<>();
		protected List<Frequency.FrequencyBuilder> calculationFrequency = new ArrayList<>();
		protected List<Frequency.FrequencyBuilder> resetFrequency = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dayCountFraction")
		public List<? extends DayCountFraction.DayCountFractionBuilder> getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction(int index) {
			if (dayCountFraction==null) {
				this.dayCountFraction = new ArrayList<>();
			}
			return getIndex(dayCountFraction, index, () -> {
						DayCountFraction.DayCountFractionBuilder newDayCountFraction = DayCountFraction.builder();
						return newDayCountFraction;
					});
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentFrequency")
		public List<? extends Frequency.FrequencyBuilder> getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreatePaymentFrequency(int index) {
			if (paymentFrequency==null) {
				this.paymentFrequency = new ArrayList<>();
			}
			return getIndex(paymentFrequency, index, () -> {
						Frequency.FrequencyBuilder newPaymentFrequency = Frequency.builder();
						return newPaymentFrequency;
					});
		}
		
		@Override
		@RosettaAttribute("calculationFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("calculationFrequency")
		public List<? extends Frequency.FrequencyBuilder> getCalculationFrequency() {
			return calculationFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateCalculationFrequency(int index) {
			if (calculationFrequency==null) {
				this.calculationFrequency = new ArrayList<>();
			}
			return getIndex(calculationFrequency, index, () -> {
						Frequency.FrequencyBuilder newCalculationFrequency = Frequency.builder();
						return newCalculationFrequency;
					});
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("resetFrequency")
		public List<? extends Frequency.FrequencyBuilder> getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateResetFrequency(int index) {
			if (resetFrequency==null) {
				this.resetFrequency = new ArrayList<>();
			}
			return getIndex(resetFrequency, index, () -> {
						Frequency.FrequencyBuilder newResetFrequency = Frequency.builder();
						return newResetFrequency;
					});
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dayCountFraction")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addDayCountFraction(DayCountFraction _dayCountFraction) {
			if (_dayCountFraction != null) {
				this.dayCountFraction.add(_dayCountFraction.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addDayCountFraction(DayCountFraction _dayCountFraction, int idx) {
			getIndex(this.dayCountFraction, idx, () -> _dayCountFraction.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addDayCountFraction(List<? extends DayCountFraction> dayCountFractions) {
			if (dayCountFractions != null) {
				for (final DayCountFraction toAdd : dayCountFractions) {
					this.dayCountFraction.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dayCountFraction")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder setDayCountFraction(List<? extends DayCountFraction> dayCountFractions) {
			if (dayCountFractions == null) {
				this.dayCountFraction = new ArrayList<>();
			} else {
				this.dayCountFraction = dayCountFractions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("paymentFrequency")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addPaymentFrequency(Frequency _paymentFrequency) {
			if (_paymentFrequency != null) {
				this.paymentFrequency.add(_paymentFrequency.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addPaymentFrequency(Frequency _paymentFrequency, int idx) {
			getIndex(this.paymentFrequency, idx, () -> _paymentFrequency.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addPaymentFrequency(List<? extends Frequency> paymentFrequencys) {
			if (paymentFrequencys != null) {
				for (final Frequency toAdd : paymentFrequencys) {
					this.paymentFrequency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("paymentFrequency")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder setPaymentFrequency(List<? extends Frequency> paymentFrequencys) {
			if (paymentFrequencys == null) {
				this.paymentFrequency = new ArrayList<>();
			} else {
				this.paymentFrequency = paymentFrequencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationFrequency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("calculationFrequency")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addCalculationFrequency(Frequency _calculationFrequency) {
			if (_calculationFrequency != null) {
				this.calculationFrequency.add(_calculationFrequency.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addCalculationFrequency(Frequency _calculationFrequency, int idx) {
			getIndex(this.calculationFrequency, idx, () -> _calculationFrequency.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addCalculationFrequency(List<? extends Frequency> calculationFrequencys) {
			if (calculationFrequencys != null) {
				for (final Frequency toAdd : calculationFrequencys) {
					this.calculationFrequency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("calculationFrequency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("calculationFrequency")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder setCalculationFrequency(List<? extends Frequency> calculationFrequencys) {
			if (calculationFrequencys == null) {
				this.calculationFrequency = new ArrayList<>();
			} else {
				this.calculationFrequency = calculationFrequencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("resetFrequency")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addResetFrequency(Frequency _resetFrequency) {
			if (_resetFrequency != null) {
				this.resetFrequency.add(_resetFrequency.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addResetFrequency(Frequency _resetFrequency, int idx) {
			getIndex(this.resetFrequency, idx, () -> _resetFrequency.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder addResetFrequency(List<? extends Frequency> resetFrequencys) {
			if (resetFrequencys != null) {
				for (final Frequency toAdd : resetFrequencys) {
					this.resetFrequency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("resetFrequency")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder setResetFrequency(List<? extends Frequency> resetFrequencys) {
			if (resetFrequencys == null) {
				this.resetFrequency = new ArrayList<>();
			} else {
				this.resetFrequency = resetFrequencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms build() {
			return new RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder prune() {
			dayCountFraction = dayCountFraction.stream().filter(b->b!=null).<DayCountFraction.DayCountFractionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			paymentFrequency = paymentFrequency.stream().filter(b->b!=null).<Frequency.FrequencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			calculationFrequency = calculationFrequency.stream().filter(b->b!=null).<Frequency.FrequencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			resetFrequency = resetFrequency.stream().filter(b->b!=null).<Frequency.FrequencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDayCountFraction()!=null && getDayCountFraction().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationFrequency()!=null && getCalculationFrequency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getResetFrequency()!=null && getResetFrequency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder o = (RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder) other;
			
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::getOrCreateDayCountFraction);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::getOrCreatePaymentFrequency);
			merger.mergeRosetta(getCalculationFrequency(), o.getCalculationFrequency(), this::getOrCreateCalculationFrequency);
			merger.mergeRosetta(getResetFrequency(), o.getResetFrequency(), this::getOrCreateResetFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductCalculationTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!ListEquals.listEquals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!ListEquals.listEquals(calculationFrequency, _that.getCalculationFrequency())) return false;
			if (!ListEquals.listEquals(resetFrequency, _that.getResetFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (calculationFrequency != null ? calculationFrequency.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductCalculationTermsBuilder {" +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"calculationFrequency=" + this.calculationFrequency + ", " +
				"resetFrequency=" + this.resetFrequency +
			'}';
		}
	}
}
