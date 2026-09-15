package fpml.consolidated.eq.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.eq.shared.meta.CalculationFromObservationMeta;
import fpml.consolidated.shared.DeterminationMethod;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Abstract base class for all calculation from observed values.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base class for all calculation from observed values.
 *
 */
@RosettaDataType(value="CalculationFromObservation", builder=CalculationFromObservation.CalculationFromObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculationFromObservation", model="fpml", builder=CalculationFromObservation.CalculationFromObservationBuilderImpl.class, version="2.1.1")
public interface CalculationFromObservation extends RosettaModelObject {

	CalculationFromObservationMeta metaData = new CalculationFromObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
	 *
	 */
	BigDecimal getInitialLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision In this context, this is AgreedInitialPrice - a specified Initial Index Level. Note: No other values from the DeterminationMethodScheme should not be provided.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision In this context, this is AgreedInitialPrice - a specified Initial Index Level. Note: No other values from the DeterminationMethodScheme should not be provided.
	 *
	 */
	DeterminationMethod getInitialLevelSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. If true this contract will strike off the closing level of the default exchange traded contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. If true this contract will strike off the closing level of the default exchange traded contract.
	 *
	 */
	Boolean getClosingLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. If true this contract will strike off the expiring level of the default exchange traded contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. If true this contract will strike off the expiring level of the default exchange traded contract.
	 *
	 */
	Boolean getExpiringLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Expected number of trading days.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Expected number of trading days.
	 *
	 */
	Integer getExpectedN();

	/*********************** Build Methods  ***********************/
	CalculationFromObservation build();
	
	CalculationFromObservation.CalculationFromObservationBuilder toBuilder();
	
	static CalculationFromObservation.CalculationFromObservationBuilder builder() {
		return new CalculationFromObservation.CalculationFromObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationFromObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationFromObservation> getType() {
		return CalculationFromObservation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
		processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.class, getInitialLevelSource());
		processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
		processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationFromObservationBuilder extends CalculationFromObservation, RosettaModelObjectBuilder {
		DeterminationMethod.DeterminationMethodBuilder getOrCreateInitialLevelSource();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getInitialLevelSource();
		CalculationFromObservation.CalculationFromObservationBuilder setInitialLevel(BigDecimal initialLevel);
		CalculationFromObservation.CalculationFromObservationBuilder setInitialLevelSource(DeterminationMethod initialLevelSource);
		CalculationFromObservation.CalculationFromObservationBuilder setClosingLevel(Boolean closingLevel);
		CalculationFromObservation.CalculationFromObservationBuilder setExpiringLevel(Boolean expiringLevel);
		CalculationFromObservation.CalculationFromObservationBuilder setExpectedN(Integer expectedN);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
			processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getInitialLevelSource());
			processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
			processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		}
		

		CalculationFromObservation.CalculationFromObservationBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationFromObservation  ***********************/
	class CalculationFromObservationImpl implements CalculationFromObservation {
		private final BigDecimal initialLevel;
		private final DeterminationMethod initialLevelSource;
		private final Boolean closingLevel;
		private final Boolean expiringLevel;
		private final Integer expectedN;
		
		protected CalculationFromObservationImpl(CalculationFromObservation.CalculationFromObservationBuilder builder) {
			this.initialLevel = builder.getInitialLevel();
			this.initialLevelSource = ofNullable(builder.getInitialLevelSource()).map(f->f.build()).orElse(null);
			this.closingLevel = builder.getClosingLevel();
			this.expiringLevel = builder.getExpiringLevel();
			this.expectedN = builder.getExpectedN();
		}
		
		@Override
		@RosettaAttribute("initialLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialLevel")
		public BigDecimal getInitialLevel() {
			return initialLevel;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialLevelSource")
		public DeterminationMethod getInitialLevelSource() {
			return initialLevelSource;
		}
		
		@Override
		@RosettaAttribute("closingLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("closingLevel")
		public Boolean getClosingLevel() {
			return closingLevel;
		}
		
		@Override
		@RosettaAttribute("expiringLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiringLevel")
		public Boolean getExpiringLevel() {
			return expiringLevel;
		}
		
		@Override
		@RosettaAttribute("expectedN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expectedN")
		public Integer getExpectedN() {
			return expectedN;
		}
		
		@Override
		public CalculationFromObservation build() {
			return this;
		}
		
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder toBuilder() {
			CalculationFromObservation.CalculationFromObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationFromObservation.CalculationFromObservationBuilder builder) {
			ofNullable(getInitialLevel()).ifPresent(builder::setInitialLevel);
			ofNullable(getInitialLevelSource()).ifPresent(builder::setInitialLevelSource);
			ofNullable(getClosingLevel()).ifPresent(builder::setClosingLevel);
			ofNullable(getExpiringLevel()).ifPresent(builder::setExpiringLevel);
			ofNullable(getExpectedN()).ifPresent(builder::setExpectedN);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationFromObservation _that = getType().cast(o);
		
			if (!Objects.equals(initialLevel, _that.getInitialLevel())) return false;
			if (!Objects.equals(initialLevelSource, _that.getInitialLevelSource())) return false;
			if (!Objects.equals(closingLevel, _that.getClosingLevel())) return false;
			if (!Objects.equals(expiringLevel, _that.getExpiringLevel())) return false;
			if (!Objects.equals(expectedN, _that.getExpectedN())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialLevel != null ? initialLevel.hashCode() : 0);
			_result = 31 * _result + (initialLevelSource != null ? initialLevelSource.hashCode() : 0);
			_result = 31 * _result + (closingLevel != null ? closingLevel.hashCode() : 0);
			_result = 31 * _result + (expiringLevel != null ? expiringLevel.hashCode() : 0);
			_result = 31 * _result + (expectedN != null ? expectedN.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationFromObservation {" +
				"initialLevel=" + this.initialLevel + ", " +
				"initialLevelSource=" + this.initialLevelSource + ", " +
				"closingLevel=" + this.closingLevel + ", " +
				"expiringLevel=" + this.expiringLevel + ", " +
				"expectedN=" + this.expectedN +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationFromObservation  ***********************/
	class CalculationFromObservationBuilderImpl implements CalculationFromObservation.CalculationFromObservationBuilder {
	
		protected BigDecimal initialLevel;
		protected DeterminationMethod.DeterminationMethodBuilder initialLevelSource;
		protected Boolean closingLevel;
		protected Boolean expiringLevel;
		protected Integer expectedN;
		
		@Override
		@RosettaAttribute("initialLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialLevel")
		public BigDecimal getInitialLevel() {
			return initialLevel;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialLevelSource")
		public DeterminationMethod.DeterminationMethodBuilder getInitialLevelSource() {
			return initialLevelSource;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateInitialLevelSource() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (initialLevelSource!=null) {
				result = initialLevelSource;
			}
			else {
				result = initialLevelSource = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("closingLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("closingLevel")
		public Boolean getClosingLevel() {
			return closingLevel;
		}
		
		@Override
		@RosettaAttribute("expiringLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiringLevel")
		public Boolean getExpiringLevel() {
			return expiringLevel;
		}
		
		@Override
		@RosettaAttribute("expectedN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expectedN")
		public Integer getExpectedN() {
			return expectedN;
		}
		
		@RosettaAttribute("initialLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialLevel")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder setInitialLevel(BigDecimal _initialLevel) {
			this.initialLevel = _initialLevel == null ? null : _initialLevel;
			return this;
		}
		
		@RosettaAttribute("initialLevelSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialLevelSource")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder setInitialLevelSource(DeterminationMethod _initialLevelSource) {
			this.initialLevelSource = _initialLevelSource == null ? null : _initialLevelSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("closingLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("closingLevel")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder setClosingLevel(Boolean _closingLevel) {
			this.closingLevel = _closingLevel == null ? null : _closingLevel;
			return this;
		}
		
		@RosettaAttribute("expiringLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiringLevel")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder setExpiringLevel(Boolean _expiringLevel) {
			this.expiringLevel = _expiringLevel == null ? null : _expiringLevel;
			return this;
		}
		
		@RosettaAttribute("expectedN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedN")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder setExpectedN(Integer _expectedN) {
			this.expectedN = _expectedN == null ? null : _expectedN;
			return this;
		}
		
		@Override
		public CalculationFromObservation build() {
			return new CalculationFromObservation.CalculationFromObservationImpl(this);
		}
		
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder prune() {
			if (initialLevelSource!=null && !initialLevelSource.prune().hasData()) initialLevelSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialLevel()!=null) return true;
			if (getInitialLevelSource()!=null && getInitialLevelSource().hasData()) return true;
			if (getClosingLevel()!=null) return true;
			if (getExpiringLevel()!=null) return true;
			if (getExpectedN()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationFromObservation.CalculationFromObservationBuilder o = (CalculationFromObservation.CalculationFromObservationBuilder) other;
			
			merger.mergeRosetta(getInitialLevelSource(), o.getInitialLevelSource(), this::setInitialLevelSource);
			
			merger.mergeBasic(getInitialLevel(), o.getInitialLevel(), this::setInitialLevel);
			merger.mergeBasic(getClosingLevel(), o.getClosingLevel(), this::setClosingLevel);
			merger.mergeBasic(getExpiringLevel(), o.getExpiringLevel(), this::setExpiringLevel);
			merger.mergeBasic(getExpectedN(), o.getExpectedN(), this::setExpectedN);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationFromObservation _that = getType().cast(o);
		
			if (!Objects.equals(initialLevel, _that.getInitialLevel())) return false;
			if (!Objects.equals(initialLevelSource, _that.getInitialLevelSource())) return false;
			if (!Objects.equals(closingLevel, _that.getClosingLevel())) return false;
			if (!Objects.equals(expiringLevel, _that.getExpiringLevel())) return false;
			if (!Objects.equals(expectedN, _that.getExpectedN())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialLevel != null ? initialLevel.hashCode() : 0);
			_result = 31 * _result + (initialLevelSource != null ? initialLevelSource.hashCode() : 0);
			_result = 31 * _result + (closingLevel != null ? closingLevel.hashCode() : 0);
			_result = 31 * _result + (expiringLevel != null ? expiringLevel.hashCode() : 0);
			_result = 31 * _result + (expectedN != null ? expectedN.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationFromObservationBuilder {" +
				"initialLevel=" + this.initialLevel + ", " +
				"initialLevelSource=" + this.initialLevelSource + ", " +
				"closingLevel=" + this.closingLevel + ", " +
				"expiringLevel=" + this.expiringLevel + ", " +
				"expectedN=" + this.expectedN +
			'}';
		}
	}
}
