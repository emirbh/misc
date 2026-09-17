package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.DividendPayoutMeta;
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
 * Provision A type describing the dividend payout ratio associated with an equity underlyer. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the dividend payout ratio associated with an equity underlyer. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified.
 *
 */
@RosettaDataType(value="DividendPayout", builder=DividendPayout.DividendPayoutBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DividendPayout", model="fpml", builder=DividendPayout.DividendPayoutBuilderImpl.class, version="2.1.1")
public interface DividendPayout extends RosettaModelObject {

	DividendPayoutMeta metaData = new DividendPayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the total actual dividend payout ratio associated with the equity underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the total actual dividend payout ratio associated with the equity underlyer.
	 *
	 */
	BigDecimal getDividendPayoutRatio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the cash actual dividend payout ratio associated with the equity underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the cash actual dividend payout ratio associated with the equity underlyer.
	 *
	 */
	BigDecimal getDividendPayoutRatioCash();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the non cash actual dividend payout ratio associated with the equity underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the non cash actual dividend payout ratio associated with the equity underlyer.
	 *
	 */
	BigDecimal getDividendPayoutRatioNonCash();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the dividend payout conditions that will be applied in the case where the actual ratio is not known, typically because of regulatory or legal uncertainties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the dividend payout conditions that will be applied in the case where the actual ratio is not known, typically because of regulatory or legal uncertainties.
	 *
	 */
	String getDividendPayoutConditions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The next upcoming dividend payment or payments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The next upcoming dividend payment or payments.
	 *
	 */
	List<? extends PendingPayment> getDividendPayment();

	/*********************** Build Methods  ***********************/
	DividendPayout build();
	
	DividendPayout.DividendPayoutBuilder toBuilder();
	
	static DividendPayout.DividendPayoutBuilder builder() {
		return new DividendPayout.DividendPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPayout> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendPayout> getType() {
		return DividendPayout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendPayoutRatio"), BigDecimal.class, getDividendPayoutRatio(), this);
		processor.processBasic(path.newSubPath("dividendPayoutRatioCash"), BigDecimal.class, getDividendPayoutRatioCash(), this);
		processor.processBasic(path.newSubPath("dividendPayoutRatioNonCash"), BigDecimal.class, getDividendPayoutRatioNonCash(), this);
		processor.processBasic(path.newSubPath("dividendPayoutConditions"), String.class, getDividendPayoutConditions(), this);
		processRosetta(path.newSubPath("dividendPayment"), processor, PendingPayment.class, getDividendPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPayoutBuilder extends DividendPayout, RosettaModelObjectBuilder {
		PendingPayment.PendingPaymentBuilder getOrCreateDividendPayment(int index);
		@Override
		List<? extends PendingPayment.PendingPaymentBuilder> getDividendPayment();
		DividendPayout.DividendPayoutBuilder setDividendPayoutRatio(BigDecimal dividendPayoutRatio);
		DividendPayout.DividendPayoutBuilder setDividendPayoutRatioCash(BigDecimal dividendPayoutRatioCash);
		DividendPayout.DividendPayoutBuilder setDividendPayoutRatioNonCash(BigDecimal dividendPayoutRatioNonCash);
		DividendPayout.DividendPayoutBuilder setDividendPayoutConditions(String dividendPayoutConditions);
		DividendPayout.DividendPayoutBuilder addDividendPayment(PendingPayment dividendPayment);
		DividendPayout.DividendPayoutBuilder addDividendPayment(PendingPayment dividendPayment, int idx);
		DividendPayout.DividendPayoutBuilder addDividendPayment(List<? extends PendingPayment> dividendPayment);
		DividendPayout.DividendPayoutBuilder setDividendPayment(List<? extends PendingPayment> dividendPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dividendPayoutRatio"), BigDecimal.class, getDividendPayoutRatio(), this);
			processor.processBasic(path.newSubPath("dividendPayoutRatioCash"), BigDecimal.class, getDividendPayoutRatioCash(), this);
			processor.processBasic(path.newSubPath("dividendPayoutRatioNonCash"), BigDecimal.class, getDividendPayoutRatioNonCash(), this);
			processor.processBasic(path.newSubPath("dividendPayoutConditions"), String.class, getDividendPayoutConditions(), this);
			processRosetta(path.newSubPath("dividendPayment"), processor, PendingPayment.PendingPaymentBuilder.class, getDividendPayment());
		}
		

		DividendPayout.DividendPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPayout  ***********************/
	class DividendPayoutImpl implements DividendPayout {
		private final BigDecimal dividendPayoutRatio;
		private final BigDecimal dividendPayoutRatioCash;
		private final BigDecimal dividendPayoutRatioNonCash;
		private final String dividendPayoutConditions;
		private final List<? extends PendingPayment> dividendPayment;
		
		protected DividendPayoutImpl(DividendPayout.DividendPayoutBuilder builder) {
			this.dividendPayoutRatio = builder.getDividendPayoutRatio();
			this.dividendPayoutRatioCash = builder.getDividendPayoutRatioCash();
			this.dividendPayoutRatioNonCash = builder.getDividendPayoutRatioNonCash();
			this.dividendPayoutConditions = builder.getDividendPayoutConditions();
			this.dividendPayment = ofNullable(builder.getDividendPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayoutRatio")
		public BigDecimal getDividendPayoutRatio() {
			return dividendPayoutRatio;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatioCash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayoutRatioCash")
		public BigDecimal getDividendPayoutRatioCash() {
			return dividendPayoutRatioCash;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatioNonCash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayoutRatioNonCash")
		public BigDecimal getDividendPayoutRatioNonCash() {
			return dividendPayoutRatioNonCash;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayoutConditions")
		public String getDividendPayoutConditions() {
			return dividendPayoutConditions;
		}
		
		@Override
		@RosettaAttribute("dividendPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dividendPayment")
		public List<? extends PendingPayment> getDividendPayment() {
			return dividendPayment;
		}
		
		@Override
		public DividendPayout build() {
			return this;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder toBuilder() {
			DividendPayout.DividendPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPayout.DividendPayoutBuilder builder) {
			ofNullable(getDividendPayoutRatio()).ifPresent(builder::setDividendPayoutRatio);
			ofNullable(getDividendPayoutRatioCash()).ifPresent(builder::setDividendPayoutRatioCash);
			ofNullable(getDividendPayoutRatioNonCash()).ifPresent(builder::setDividendPayoutRatioNonCash);
			ofNullable(getDividendPayoutConditions()).ifPresent(builder::setDividendPayoutConditions);
			ofNullable(getDividendPayment()).ifPresent(builder::setDividendPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayout _that = getType().cast(o);
		
			if (!Objects.equals(dividendPayoutRatio, _that.getDividendPayoutRatio())) return false;
			if (!Objects.equals(dividendPayoutRatioCash, _that.getDividendPayoutRatioCash())) return false;
			if (!Objects.equals(dividendPayoutRatioNonCash, _that.getDividendPayoutRatioNonCash())) return false;
			if (!Objects.equals(dividendPayoutConditions, _that.getDividendPayoutConditions())) return false;
			if (!ListEquals.listEquals(dividendPayment, _that.getDividendPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPayoutRatio != null ? dividendPayoutRatio.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioCash != null ? dividendPayoutRatioCash.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioNonCash != null ? dividendPayoutRatioNonCash.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutConditions != null ? dividendPayoutConditions.hashCode() : 0);
			_result = 31 * _result + (dividendPayment != null ? dividendPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayout {" +
				"dividendPayoutRatio=" + this.dividendPayoutRatio + ", " +
				"dividendPayoutRatioCash=" + this.dividendPayoutRatioCash + ", " +
				"dividendPayoutRatioNonCash=" + this.dividendPayoutRatioNonCash + ", " +
				"dividendPayoutConditions=" + this.dividendPayoutConditions + ", " +
				"dividendPayment=" + this.dividendPayment +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPayout  ***********************/
	class DividendPayoutBuilderImpl implements DividendPayout.DividendPayoutBuilder {
	
		protected BigDecimal dividendPayoutRatio;
		protected BigDecimal dividendPayoutRatioCash;
		protected BigDecimal dividendPayoutRatioNonCash;
		protected String dividendPayoutConditions;
		protected List<PendingPayment.PendingPaymentBuilder> dividendPayment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dividendPayoutRatio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayoutRatio")
		public BigDecimal getDividendPayoutRatio() {
			return dividendPayoutRatio;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatioCash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayoutRatioCash")
		public BigDecimal getDividendPayoutRatioCash() {
			return dividendPayoutRatioCash;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatioNonCash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayoutRatioNonCash")
		public BigDecimal getDividendPayoutRatioNonCash() {
			return dividendPayoutRatioNonCash;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayoutConditions")
		public String getDividendPayoutConditions() {
			return dividendPayoutConditions;
		}
		
		@Override
		@RosettaAttribute("dividendPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dividendPayment")
		public List<? extends PendingPayment.PendingPaymentBuilder> getDividendPayment() {
			return dividendPayment;
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder getOrCreateDividendPayment(int index) {
			if (dividendPayment==null) {
				this.dividendPayment = new ArrayList<>();
			}
			return getIndex(dividendPayment, index, () -> {
						PendingPayment.PendingPaymentBuilder newDividendPayment = PendingPayment.builder();
						return newDividendPayment;
					});
		}
		
		@RosettaAttribute("dividendPayoutRatio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPayoutRatio")
		@Override
		public DividendPayout.DividendPayoutBuilder setDividendPayoutRatio(BigDecimal _dividendPayoutRatio) {
			this.dividendPayoutRatio = _dividendPayoutRatio == null ? null : _dividendPayoutRatio;
			return this;
		}
		
		@RosettaAttribute("dividendPayoutRatioCash")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPayoutRatioCash")
		@Override
		public DividendPayout.DividendPayoutBuilder setDividendPayoutRatioCash(BigDecimal _dividendPayoutRatioCash) {
			this.dividendPayoutRatioCash = _dividendPayoutRatioCash == null ? null : _dividendPayoutRatioCash;
			return this;
		}
		
		@RosettaAttribute("dividendPayoutRatioNonCash")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPayoutRatioNonCash")
		@Override
		public DividendPayout.DividendPayoutBuilder setDividendPayoutRatioNonCash(BigDecimal _dividendPayoutRatioNonCash) {
			this.dividendPayoutRatioNonCash = _dividendPayoutRatioNonCash == null ? null : _dividendPayoutRatioNonCash;
			return this;
		}
		
		@RosettaAttribute("dividendPayoutConditions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPayoutConditions")
		@Override
		public DividendPayout.DividendPayoutBuilder setDividendPayoutConditions(String _dividendPayoutConditions) {
			this.dividendPayoutConditions = _dividendPayoutConditions == null ? null : _dividendPayoutConditions;
			return this;
		}
		
		@RosettaAttribute("dividendPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dividendPayment")
		@Override
		public DividendPayout.DividendPayoutBuilder addDividendPayment(PendingPayment _dividendPayment) {
			if (_dividendPayment != null) {
				this.dividendPayment.add(_dividendPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder addDividendPayment(PendingPayment _dividendPayment, int idx) {
			getIndex(this.dividendPayment, idx, () -> _dividendPayment.toBuilder());
			return this;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder addDividendPayment(List<? extends PendingPayment> dividendPayments) {
			if (dividendPayments != null) {
				for (final PendingPayment toAdd : dividendPayments) {
					this.dividendPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dividendPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dividendPayment")
		@Override
		public DividendPayout.DividendPayoutBuilder setDividendPayment(List<? extends PendingPayment> dividendPayments) {
			if (dividendPayments == null) {
				this.dividendPayment = new ArrayList<>();
			} else {
				this.dividendPayment = dividendPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DividendPayout build() {
			return new DividendPayout.DividendPayoutImpl(this);
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayout.DividendPayoutBuilder prune() {
			dividendPayment = dividendPayment.stream().filter(b->b!=null).<PendingPayment.PendingPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendPayoutRatio()!=null) return true;
			if (getDividendPayoutRatioCash()!=null) return true;
			if (getDividendPayoutRatioNonCash()!=null) return true;
			if (getDividendPayoutConditions()!=null) return true;
			if (getDividendPayment()!=null && getDividendPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayout.DividendPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPayout.DividendPayoutBuilder o = (DividendPayout.DividendPayoutBuilder) other;
			
			merger.mergeRosetta(getDividendPayment(), o.getDividendPayment(), this::getOrCreateDividendPayment);
			
			merger.mergeBasic(getDividendPayoutRatio(), o.getDividendPayoutRatio(), this::setDividendPayoutRatio);
			merger.mergeBasic(getDividendPayoutRatioCash(), o.getDividendPayoutRatioCash(), this::setDividendPayoutRatioCash);
			merger.mergeBasic(getDividendPayoutRatioNonCash(), o.getDividendPayoutRatioNonCash(), this::setDividendPayoutRatioNonCash);
			merger.mergeBasic(getDividendPayoutConditions(), o.getDividendPayoutConditions(), this::setDividendPayoutConditions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayout _that = getType().cast(o);
		
			if (!Objects.equals(dividendPayoutRatio, _that.getDividendPayoutRatio())) return false;
			if (!Objects.equals(dividendPayoutRatioCash, _that.getDividendPayoutRatioCash())) return false;
			if (!Objects.equals(dividendPayoutRatioNonCash, _that.getDividendPayoutRatioNonCash())) return false;
			if (!Objects.equals(dividendPayoutConditions, _that.getDividendPayoutConditions())) return false;
			if (!ListEquals.listEquals(dividendPayment, _that.getDividendPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPayoutRatio != null ? dividendPayoutRatio.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioCash != null ? dividendPayoutRatioCash.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioNonCash != null ? dividendPayoutRatioNonCash.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutConditions != null ? dividendPayoutConditions.hashCode() : 0);
			_result = 31 * _result + (dividendPayment != null ? dividendPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayoutBuilder {" +
				"dividendPayoutRatio=" + this.dividendPayoutRatio + ", " +
				"dividendPayoutRatioCash=" + this.dividendPayoutRatioCash + ", " +
				"dividendPayoutRatioNonCash=" + this.dividendPayoutRatioNonCash + ", " +
				"dividendPayoutConditions=" + this.dividendPayoutConditions + ", " +
				"dividendPayment=" + this.dividendPayment +
			'}';
		}
	}
}
