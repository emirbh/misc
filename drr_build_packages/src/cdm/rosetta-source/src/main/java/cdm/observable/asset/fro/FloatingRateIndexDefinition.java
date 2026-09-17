package cdm.observable.asset.fro;

import cdm.observable.asset.fro.meta.FloatingRateIndexDefinitionMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexDefinition", builder=FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexDefinition", model="cdm", builder=FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexDefinition extends RosettaModelObject {

	FloatingRateIndexDefinitionMeta metaData = new FloatingRateIndexDefinitionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The underlying FRO name and designated maturity.
	 */
	FloatingRateIndexIdentification getFro();
	/**
	 * Any calculation default values.
	 */
	FloatingRateIndexCalculationDefaults getCalculationDefaults();
	/**
	 * The definition version or versions supported by the FRO.
	 */
	List<? extends ContractualDefinition> getSupportedDefinition();
	/**
	 * The source of an FRO, particularly if not a Contractual Definition (e.g. the broker rates matrix).
	 */
	String getDefinitionalSource();
	Boolean getDesignatedMaturityApplicable();
	/**
	 * Any mappings to other FRos.
	 */
	FloatingRateIndexMappings getMappings();
	/**
	 * Any mappings to other codes for this index.
	 */
	FloatingRateIndexExternalMappings getExternalMappings();
	/**
	 * YES / NO to flag FROs identified by the FpML Syndicated Loan WG as having underlying benchmark that may also be referenced in syndicated loans.
	 */
	Boolean getInLoan();
	/**
	 * FRO History
	 */
	FroHistory getHistory();
	/**
	 * Deprecation and Code Descriptions
	 */
	String getDeprecationReason();
	/**
	 * FpML Description
	 */
	String getFpmlDescription();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexDefinition build();
	
	FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder toBuilder();
	
	static FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder builder() {
		return new FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexDefinition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexDefinition> getType() {
		return FloatingRateIndexDefinition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fro"), processor, FloatingRateIndexIdentification.class, getFro());
		processRosetta(path.newSubPath("calculationDefaults"), processor, FloatingRateIndexCalculationDefaults.class, getCalculationDefaults());
		processRosetta(path.newSubPath("supportedDefinition"), processor, ContractualDefinition.class, getSupportedDefinition());
		processor.processBasic(path.newSubPath("definitionalSource"), String.class, getDefinitionalSource(), this);
		processor.processBasic(path.newSubPath("designatedMaturityApplicable"), Boolean.class, getDesignatedMaturityApplicable(), this);
		processRosetta(path.newSubPath("mappings"), processor, FloatingRateIndexMappings.class, getMappings());
		processRosetta(path.newSubPath("externalMappings"), processor, FloatingRateIndexExternalMappings.class, getExternalMappings());
		processor.processBasic(path.newSubPath("inLoan"), Boolean.class, getInLoan(), this);
		processRosetta(path.newSubPath("history"), processor, FroHistory.class, getHistory());
		processor.processBasic(path.newSubPath("deprecationReason"), String.class, getDeprecationReason(), this);
		processor.processBasic(path.newSubPath("fpmlDescription"), String.class, getFpmlDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexDefinitionBuilder extends FloatingRateIndexDefinition, RosettaModelObjectBuilder {
		FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder getOrCreateFro();
		@Override
		FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder getFro();
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder getOrCreateCalculationDefaults();
		@Override
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder getCalculationDefaults();
		ContractualDefinition.ContractualDefinitionBuilder getOrCreateSupportedDefinition(int index);
		@Override
		List<? extends ContractualDefinition.ContractualDefinitionBuilder> getSupportedDefinition();
		FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder getOrCreateMappings();
		@Override
		FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder getMappings();
		FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder getOrCreateExternalMappings();
		@Override
		FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder getExternalMappings();
		FroHistory.FroHistoryBuilder getOrCreateHistory();
		@Override
		FroHistory.FroHistoryBuilder getHistory();
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setFro(FloatingRateIndexIdentification fro);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setCalculationDefaults(FloatingRateIndexCalculationDefaults calculationDefaults);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder addSupportedDefinition(ContractualDefinition supportedDefinition);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder addSupportedDefinition(ContractualDefinition supportedDefinition, int idx);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder addSupportedDefinition(List<? extends ContractualDefinition> supportedDefinition);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setSupportedDefinition(List<? extends ContractualDefinition> supportedDefinition);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setDefinitionalSource(String definitionalSource);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setDesignatedMaturityApplicable(Boolean designatedMaturityApplicable);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setMappings(FloatingRateIndexMappings mappings);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setExternalMappings(FloatingRateIndexExternalMappings externalMappings);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setInLoan(Boolean inLoan);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setHistory(FroHistory history);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setDeprecationReason(String deprecationReason);
		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setFpmlDescription(String fpmlDescription);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fro"), processor, FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder.class, getFro());
			processRosetta(path.newSubPath("calculationDefaults"), processor, FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder.class, getCalculationDefaults());
			processRosetta(path.newSubPath("supportedDefinition"), processor, ContractualDefinition.ContractualDefinitionBuilder.class, getSupportedDefinition());
			processor.processBasic(path.newSubPath("definitionalSource"), String.class, getDefinitionalSource(), this);
			processor.processBasic(path.newSubPath("designatedMaturityApplicable"), Boolean.class, getDesignatedMaturityApplicable(), this);
			processRosetta(path.newSubPath("mappings"), processor, FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder.class, getMappings());
			processRosetta(path.newSubPath("externalMappings"), processor, FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder.class, getExternalMappings());
			processor.processBasic(path.newSubPath("inLoan"), Boolean.class, getInLoan(), this);
			processRosetta(path.newSubPath("history"), processor, FroHistory.FroHistoryBuilder.class, getHistory());
			processor.processBasic(path.newSubPath("deprecationReason"), String.class, getDeprecationReason(), this);
			processor.processBasic(path.newSubPath("fpmlDescription"), String.class, getFpmlDescription(), this);
		}
		

		FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexDefinition  ***********************/
	class FloatingRateIndexDefinitionImpl implements FloatingRateIndexDefinition {
		private final FloatingRateIndexIdentification fro;
		private final FloatingRateIndexCalculationDefaults calculationDefaults;
		private final List<? extends ContractualDefinition> supportedDefinition;
		private final String definitionalSource;
		private final Boolean designatedMaturityApplicable;
		private final FloatingRateIndexMappings mappings;
		private final FloatingRateIndexExternalMappings externalMappings;
		private final Boolean inLoan;
		private final FroHistory history;
		private final String deprecationReason;
		private final String fpmlDescription;
		
		protected FloatingRateIndexDefinitionImpl(FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder builder) {
			this.fro = ofNullable(builder.getFro()).map(f->f.build()).orElse(null);
			this.calculationDefaults = ofNullable(builder.getCalculationDefaults()).map(f->f.build()).orElse(null);
			this.supportedDefinition = ofNullable(builder.getSupportedDefinition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.definitionalSource = builder.getDefinitionalSource();
			this.designatedMaturityApplicable = builder.getDesignatedMaturityApplicable();
			this.mappings = ofNullable(builder.getMappings()).map(f->f.build()).orElse(null);
			this.externalMappings = ofNullable(builder.getExternalMappings()).map(f->f.build()).orElse(null);
			this.inLoan = builder.getInLoan();
			this.history = ofNullable(builder.getHistory()).map(f->f.build()).orElse(null);
			this.deprecationReason = builder.getDeprecationReason();
			this.fpmlDescription = builder.getFpmlDescription();
		}
		
		@Override
		@RosettaAttribute("fro")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fro")
		public FloatingRateIndexIdentification getFro() {
			return fro;
		}
		
		@Override
		@RosettaAttribute("calculationDefaults")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDefaults")
		public FloatingRateIndexCalculationDefaults getCalculationDefaults() {
			return calculationDefaults;
		}
		
		@Override
		@RosettaAttribute("supportedDefinition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supportedDefinition")
		public List<? extends ContractualDefinition> getSupportedDefinition() {
			return supportedDefinition;
		}
		
		@Override
		@RosettaAttribute("definitionalSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definitionalSource")
		public String getDefinitionalSource() {
			return definitionalSource;
		}
		
		@Override
		@RosettaAttribute("designatedMaturityApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("designatedMaturityApplicable")
		public Boolean getDesignatedMaturityApplicable() {
			return designatedMaturityApplicable;
		}
		
		@Override
		@RosettaAttribute("mappings")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mappings")
		public FloatingRateIndexMappings getMappings() {
			return mappings;
		}
		
		@Override
		@RosettaAttribute("externalMappings")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("externalMappings")
		public FloatingRateIndexExternalMappings getExternalMappings() {
			return externalMappings;
		}
		
		@Override
		@RosettaAttribute("inLoan")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inLoan")
		public Boolean getInLoan() {
			return inLoan;
		}
		
		@Override
		@RosettaAttribute("history")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("history")
		public FroHistory getHistory() {
			return history;
		}
		
		@Override
		@RosettaAttribute("deprecationReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deprecationReason")
		public String getDeprecationReason() {
			return deprecationReason;
		}
		
		@Override
		@RosettaAttribute("fpmlDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fpmlDescription")
		public String getFpmlDescription() {
			return fpmlDescription;
		}
		
		@Override
		public FloatingRateIndexDefinition build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder toBuilder() {
			FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder builder) {
			ofNullable(getFro()).ifPresent(builder::setFro);
			ofNullable(getCalculationDefaults()).ifPresent(builder::setCalculationDefaults);
			ofNullable(getSupportedDefinition()).ifPresent(builder::setSupportedDefinition);
			ofNullable(getDefinitionalSource()).ifPresent(builder::setDefinitionalSource);
			ofNullable(getDesignatedMaturityApplicable()).ifPresent(builder::setDesignatedMaturityApplicable);
			ofNullable(getMappings()).ifPresent(builder::setMappings);
			ofNullable(getExternalMappings()).ifPresent(builder::setExternalMappings);
			ofNullable(getInLoan()).ifPresent(builder::setInLoan);
			ofNullable(getHistory()).ifPresent(builder::setHistory);
			ofNullable(getDeprecationReason()).ifPresent(builder::setDeprecationReason);
			ofNullable(getFpmlDescription()).ifPresent(builder::setFpmlDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexDefinition _that = getType().cast(o);
		
			if (!Objects.equals(fro, _that.getFro())) return false;
			if (!Objects.equals(calculationDefaults, _that.getCalculationDefaults())) return false;
			if (!ListEquals.listEquals(supportedDefinition, _that.getSupportedDefinition())) return false;
			if (!Objects.equals(definitionalSource, _that.getDefinitionalSource())) return false;
			if (!Objects.equals(designatedMaturityApplicable, _that.getDesignatedMaturityApplicable())) return false;
			if (!Objects.equals(mappings, _that.getMappings())) return false;
			if (!Objects.equals(externalMappings, _that.getExternalMappings())) return false;
			if (!Objects.equals(inLoan, _that.getInLoan())) return false;
			if (!Objects.equals(history, _that.getHistory())) return false;
			if (!Objects.equals(deprecationReason, _that.getDeprecationReason())) return false;
			if (!Objects.equals(fpmlDescription, _that.getFpmlDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fro != null ? fro.hashCode() : 0);
			_result = 31 * _result + (calculationDefaults != null ? calculationDefaults.hashCode() : 0);
			_result = 31 * _result + (supportedDefinition != null ? supportedDefinition.hashCode() : 0);
			_result = 31 * _result + (definitionalSource != null ? definitionalSource.hashCode() : 0);
			_result = 31 * _result + (designatedMaturityApplicable != null ? designatedMaturityApplicable.hashCode() : 0);
			_result = 31 * _result + (mappings != null ? mappings.hashCode() : 0);
			_result = 31 * _result + (externalMappings != null ? externalMappings.hashCode() : 0);
			_result = 31 * _result + (inLoan != null ? inLoan.hashCode() : 0);
			_result = 31 * _result + (history != null ? history.hashCode() : 0);
			_result = 31 * _result + (deprecationReason != null ? deprecationReason.hashCode() : 0);
			_result = 31 * _result + (fpmlDescription != null ? fpmlDescription.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexDefinition {" +
				"fro=" + this.fro + ", " +
				"calculationDefaults=" + this.calculationDefaults + ", " +
				"supportedDefinition=" + this.supportedDefinition + ", " +
				"definitionalSource=" + this.definitionalSource + ", " +
				"designatedMaturityApplicable=" + this.designatedMaturityApplicable + ", " +
				"mappings=" + this.mappings + ", " +
				"externalMappings=" + this.externalMappings + ", " +
				"inLoan=" + this.inLoan + ", " +
				"history=" + this.history + ", " +
				"deprecationReason=" + this.deprecationReason + ", " +
				"fpmlDescription=" + this.fpmlDescription +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexDefinition  ***********************/
	class FloatingRateIndexDefinitionBuilderImpl implements FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder {
	
		protected FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder fro;
		protected FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder calculationDefaults;
		protected List<ContractualDefinition.ContractualDefinitionBuilder> supportedDefinition = new ArrayList<>();
		protected String definitionalSource;
		protected Boolean designatedMaturityApplicable;
		protected FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder mappings;
		protected FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder externalMappings;
		protected Boolean inLoan;
		protected FroHistory.FroHistoryBuilder history;
		protected String deprecationReason;
		protected String fpmlDescription;
		
		@Override
		@RosettaAttribute("fro")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fro")
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder getFro() {
			return fro;
		}
		
		@Override
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder getOrCreateFro() {
			FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder result;
			if (fro!=null) {
				result = fro;
			}
			else {
				result = fro = FloatingRateIndexIdentification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDefaults")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDefaults")
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder getCalculationDefaults() {
			return calculationDefaults;
		}
		
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder getOrCreateCalculationDefaults() {
			FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder result;
			if (calculationDefaults!=null) {
				result = calculationDefaults;
			}
			else {
				result = calculationDefaults = FloatingRateIndexCalculationDefaults.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supportedDefinition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supportedDefinition")
		public List<? extends ContractualDefinition.ContractualDefinitionBuilder> getSupportedDefinition() {
			return supportedDefinition;
		}
		
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder getOrCreateSupportedDefinition(int index) {
			if (supportedDefinition==null) {
				this.supportedDefinition = new ArrayList<>();
			}
			return getIndex(supportedDefinition, index, () -> {
						ContractualDefinition.ContractualDefinitionBuilder newSupportedDefinition = ContractualDefinition.builder();
						return newSupportedDefinition;
					});
		}
		
		@Override
		@RosettaAttribute("definitionalSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definitionalSource")
		public String getDefinitionalSource() {
			return definitionalSource;
		}
		
		@Override
		@RosettaAttribute("designatedMaturityApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("designatedMaturityApplicable")
		public Boolean getDesignatedMaturityApplicable() {
			return designatedMaturityApplicable;
		}
		
		@Override
		@RosettaAttribute("mappings")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mappings")
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder getMappings() {
			return mappings;
		}
		
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder getOrCreateMappings() {
			FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder result;
			if (mappings!=null) {
				result = mappings;
			}
			else {
				result = mappings = FloatingRateIndexMappings.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("externalMappings")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("externalMappings")
		public FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder getExternalMappings() {
			return externalMappings;
		}
		
		@Override
		public FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder getOrCreateExternalMappings() {
			FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder result;
			if (externalMappings!=null) {
				result = externalMappings;
			}
			else {
				result = externalMappings = FloatingRateIndexExternalMappings.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("inLoan")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inLoan")
		public Boolean getInLoan() {
			return inLoan;
		}
		
		@Override
		@RosettaAttribute("history")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("history")
		public FroHistory.FroHistoryBuilder getHistory() {
			return history;
		}
		
		@Override
		public FroHistory.FroHistoryBuilder getOrCreateHistory() {
			FroHistory.FroHistoryBuilder result;
			if (history!=null) {
				result = history;
			}
			else {
				result = history = FroHistory.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deprecationReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deprecationReason")
		public String getDeprecationReason() {
			return deprecationReason;
		}
		
		@Override
		@RosettaAttribute("fpmlDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fpmlDescription")
		public String getFpmlDescription() {
			return fpmlDescription;
		}
		
		@RosettaAttribute("fro")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fro")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setFro(FloatingRateIndexIdentification _fro) {
			this.fro = _fro == null ? null : _fro.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationDefaults")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDefaults")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setCalculationDefaults(FloatingRateIndexCalculationDefaults _calculationDefaults) {
			this.calculationDefaults = _calculationDefaults == null ? null : _calculationDefaults.toBuilder();
			return this;
		}
		
		@RosettaAttribute("supportedDefinition")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supportedDefinition")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder addSupportedDefinition(ContractualDefinition _supportedDefinition) {
			if (_supportedDefinition != null) {
				this.supportedDefinition.add(_supportedDefinition.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder addSupportedDefinition(ContractualDefinition _supportedDefinition, int idx) {
			getIndex(this.supportedDefinition, idx, () -> _supportedDefinition.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder addSupportedDefinition(List<? extends ContractualDefinition> supportedDefinitions) {
			if (supportedDefinitions != null) {
				for (final ContractualDefinition toAdd : supportedDefinitions) {
					this.supportedDefinition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("supportedDefinition")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("supportedDefinition")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setSupportedDefinition(List<? extends ContractualDefinition> supportedDefinitions) {
			if (supportedDefinitions == null) {
				this.supportedDefinition = new ArrayList<>();
			} else {
				this.supportedDefinition = supportedDefinitions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("definitionalSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionalSource")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setDefinitionalSource(String _definitionalSource) {
			this.definitionalSource = _definitionalSource == null ? null : _definitionalSource;
			return this;
		}
		
		@RosettaAttribute("designatedMaturityApplicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("designatedMaturityApplicable")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setDesignatedMaturityApplicable(Boolean _designatedMaturityApplicable) {
			this.designatedMaturityApplicable = _designatedMaturityApplicable == null ? null : _designatedMaturityApplicable;
			return this;
		}
		
		@RosettaAttribute("mappings")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mappings")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setMappings(FloatingRateIndexMappings _mappings) {
			this.mappings = _mappings == null ? null : _mappings.toBuilder();
			return this;
		}
		
		@RosettaAttribute("externalMappings")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("externalMappings")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setExternalMappings(FloatingRateIndexExternalMappings _externalMappings) {
			this.externalMappings = _externalMappings == null ? null : _externalMappings.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inLoan")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inLoan")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setInLoan(Boolean _inLoan) {
			this.inLoan = _inLoan == null ? null : _inLoan;
			return this;
		}
		
		@RosettaAttribute("history")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("history")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setHistory(FroHistory _history) {
			this.history = _history == null ? null : _history.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deprecationReason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deprecationReason")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setDeprecationReason(String _deprecationReason) {
			this.deprecationReason = _deprecationReason == null ? null : _deprecationReason;
			return this;
		}
		
		@RosettaAttribute("fpmlDescription")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fpmlDescription")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder setFpmlDescription(String _fpmlDescription) {
			this.fpmlDescription = _fpmlDescription == null ? null : _fpmlDescription;
			return this;
		}
		
		@Override
		public FloatingRateIndexDefinition build() {
			return new FloatingRateIndexDefinition.FloatingRateIndexDefinitionImpl(this);
		}
		
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder prune() {
			if (fro!=null && !fro.prune().hasData()) fro = null;
			if (calculationDefaults!=null && !calculationDefaults.prune().hasData()) calculationDefaults = null;
			supportedDefinition = supportedDefinition.stream().filter(b->b!=null).<ContractualDefinition.ContractualDefinitionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (mappings!=null && !mappings.prune().hasData()) mappings = null;
			if (externalMappings!=null && !externalMappings.prune().hasData()) externalMappings = null;
			if (history!=null && !history.prune().hasData()) history = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFro()!=null && getFro().hasData()) return true;
			if (getCalculationDefaults()!=null && getCalculationDefaults().hasData()) return true;
			if (getSupportedDefinition()!=null && getSupportedDefinition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDefinitionalSource()!=null) return true;
			if (getDesignatedMaturityApplicable()!=null) return true;
			if (getMappings()!=null && getMappings().hasData()) return true;
			if (getExternalMappings()!=null && getExternalMappings().hasData()) return true;
			if (getInLoan()!=null) return true;
			if (getHistory()!=null && getHistory().hasData()) return true;
			if (getDeprecationReason()!=null) return true;
			if (getFpmlDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder o = (FloatingRateIndexDefinition.FloatingRateIndexDefinitionBuilder) other;
			
			merger.mergeRosetta(getFro(), o.getFro(), this::setFro);
			merger.mergeRosetta(getCalculationDefaults(), o.getCalculationDefaults(), this::setCalculationDefaults);
			merger.mergeRosetta(getSupportedDefinition(), o.getSupportedDefinition(), this::getOrCreateSupportedDefinition);
			merger.mergeRosetta(getMappings(), o.getMappings(), this::setMappings);
			merger.mergeRosetta(getExternalMappings(), o.getExternalMappings(), this::setExternalMappings);
			merger.mergeRosetta(getHistory(), o.getHistory(), this::setHistory);
			
			merger.mergeBasic(getDefinitionalSource(), o.getDefinitionalSource(), this::setDefinitionalSource);
			merger.mergeBasic(getDesignatedMaturityApplicable(), o.getDesignatedMaturityApplicable(), this::setDesignatedMaturityApplicable);
			merger.mergeBasic(getInLoan(), o.getInLoan(), this::setInLoan);
			merger.mergeBasic(getDeprecationReason(), o.getDeprecationReason(), this::setDeprecationReason);
			merger.mergeBasic(getFpmlDescription(), o.getFpmlDescription(), this::setFpmlDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexDefinition _that = getType().cast(o);
		
			if (!Objects.equals(fro, _that.getFro())) return false;
			if (!Objects.equals(calculationDefaults, _that.getCalculationDefaults())) return false;
			if (!ListEquals.listEquals(supportedDefinition, _that.getSupportedDefinition())) return false;
			if (!Objects.equals(definitionalSource, _that.getDefinitionalSource())) return false;
			if (!Objects.equals(designatedMaturityApplicable, _that.getDesignatedMaturityApplicable())) return false;
			if (!Objects.equals(mappings, _that.getMappings())) return false;
			if (!Objects.equals(externalMappings, _that.getExternalMappings())) return false;
			if (!Objects.equals(inLoan, _that.getInLoan())) return false;
			if (!Objects.equals(history, _that.getHistory())) return false;
			if (!Objects.equals(deprecationReason, _that.getDeprecationReason())) return false;
			if (!Objects.equals(fpmlDescription, _that.getFpmlDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fro != null ? fro.hashCode() : 0);
			_result = 31 * _result + (calculationDefaults != null ? calculationDefaults.hashCode() : 0);
			_result = 31 * _result + (supportedDefinition != null ? supportedDefinition.hashCode() : 0);
			_result = 31 * _result + (definitionalSource != null ? definitionalSource.hashCode() : 0);
			_result = 31 * _result + (designatedMaturityApplicable != null ? designatedMaturityApplicable.hashCode() : 0);
			_result = 31 * _result + (mappings != null ? mappings.hashCode() : 0);
			_result = 31 * _result + (externalMappings != null ? externalMappings.hashCode() : 0);
			_result = 31 * _result + (inLoan != null ? inLoan.hashCode() : 0);
			_result = 31 * _result + (history != null ? history.hashCode() : 0);
			_result = 31 * _result + (deprecationReason != null ? deprecationReason.hashCode() : 0);
			_result = 31 * _result + (fpmlDescription != null ? fpmlDescription.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexDefinitionBuilder {" +
				"fro=" + this.fro + ", " +
				"calculationDefaults=" + this.calculationDefaults + ", " +
				"supportedDefinition=" + this.supportedDefinition + ", " +
				"definitionalSource=" + this.definitionalSource + ", " +
				"designatedMaturityApplicable=" + this.designatedMaturityApplicable + ", " +
				"mappings=" + this.mappings + ", " +
				"externalMappings=" + this.externalMappings + ", " +
				"inLoan=" + this.inLoan + ", " +
				"history=" + this.history + ", " +
				"deprecationReason=" + this.deprecationReason + ", " +
				"fpmlDescription=" + this.fpmlDescription +
			'}';
		}
	}
}
