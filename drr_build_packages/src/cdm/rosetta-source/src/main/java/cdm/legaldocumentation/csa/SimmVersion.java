package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.SimmVersionMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the ISDA SIMM version that applies to the ISDA 2018 CSA for Initial Margin.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2018 ISDA 2018 Credit Support Annex For Initial Margin  
 * paragraph "13 General Principles" * clause "(ee)(1)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="SimmVersion", builder=SimmVersion.SimmVersionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SimmVersion", model="cdm", builder=SimmVersion.SimmVersionBuilderImpl.class, version="6.23.0")
public interface SimmVersion extends RosettaModelObject {

	SimmVersionMeta metaData = new SimmVersionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A boolean attribute to determine whether the SIMM version is specified for the purpose of the legal agreement.
	 */
	Boolean getIsSpecified();
	/**
	 * The party which the specified SIMM version applies to.
	 */
	CounterpartyRoleEnum getPartyVersion();
	/**
	 * The SIMM version exception when specified as a customized approach by the party.
	 */
	String getAsSpecified();

	/*********************** Build Methods  ***********************/
	SimmVersion build();
	
	SimmVersion.SimmVersionBuilder toBuilder();
	
	static SimmVersion.SimmVersionBuilder builder() {
		return new SimmVersion.SimmVersionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SimmVersion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SimmVersion> getType() {
		return SimmVersion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
		processor.processBasic(path.newSubPath("partyVersion"), CounterpartyRoleEnum.class, getPartyVersion(), this);
		processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SimmVersionBuilder extends SimmVersion, RosettaModelObjectBuilder {
		SimmVersion.SimmVersionBuilder setIsSpecified(Boolean isSpecified);
		SimmVersion.SimmVersionBuilder setPartyVersion(CounterpartyRoleEnum partyVersion);
		SimmVersion.SimmVersionBuilder setAsSpecified(String asSpecified);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
			processor.processBasic(path.newSubPath("partyVersion"), CounterpartyRoleEnum.class, getPartyVersion(), this);
			processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
		}
		

		SimmVersion.SimmVersionBuilder prune();
	}

	/*********************** Immutable Implementation of SimmVersion  ***********************/
	class SimmVersionImpl implements SimmVersion {
		private final Boolean isSpecified;
		private final CounterpartyRoleEnum partyVersion;
		private final String asSpecified;
		
		protected SimmVersionImpl(SimmVersion.SimmVersionBuilder builder) {
			this.isSpecified = builder.getIsSpecified();
			this.partyVersion = builder.getPartyVersion();
			this.asSpecified = builder.getAsSpecified();
		}
		
		@Override
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isSpecified")
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		@RosettaAttribute("partyVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyVersion")
		public CounterpartyRoleEnum getPartyVersion() {
			return partyVersion;
		}
		
		@Override
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asSpecified")
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public SimmVersion build() {
			return this;
		}
		
		@Override
		public SimmVersion.SimmVersionBuilder toBuilder() {
			SimmVersion.SimmVersionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimmVersion.SimmVersionBuilder builder) {
			ofNullable(getIsSpecified()).ifPresent(builder::setIsSpecified);
			ofNullable(getPartyVersion()).ifPresent(builder::setPartyVersion);
			ofNullable(getAsSpecified()).ifPresent(builder::setAsSpecified);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmVersion _that = getType().cast(o);
		
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(partyVersion, _that.getPartyVersion())) return false;
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (partyVersion != null ? partyVersion.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimmVersion {" +
				"isSpecified=" + this.isSpecified + ", " +
				"partyVersion=" + this.partyVersion + ", " +
				"asSpecified=" + this.asSpecified +
			'}';
		}
	}

	/*********************** Builder Implementation of SimmVersion  ***********************/
	class SimmVersionBuilderImpl implements SimmVersion.SimmVersionBuilder {
	
		protected Boolean isSpecified;
		protected CounterpartyRoleEnum partyVersion;
		protected String asSpecified;
		
		@Override
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isSpecified")
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		@RosettaAttribute("partyVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyVersion")
		public CounterpartyRoleEnum getPartyVersion() {
			return partyVersion;
		}
		
		@Override
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asSpecified")
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isSpecified")
		@Override
		public SimmVersion.SimmVersionBuilder setIsSpecified(Boolean _isSpecified) {
			this.isSpecified = _isSpecified == null ? null : _isSpecified;
			return this;
		}
		
		@RosettaAttribute("partyVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyVersion")
		@Override
		public SimmVersion.SimmVersionBuilder setPartyVersion(CounterpartyRoleEnum _partyVersion) {
			this.partyVersion = _partyVersion == null ? null : _partyVersion;
			return this;
		}
		
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asSpecified")
		@Override
		public SimmVersion.SimmVersionBuilder setAsSpecified(String _asSpecified) {
			this.asSpecified = _asSpecified == null ? null : _asSpecified;
			return this;
		}
		
		@Override
		public SimmVersion build() {
			return new SimmVersion.SimmVersionImpl(this);
		}
		
		@Override
		public SimmVersion.SimmVersionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmVersion.SimmVersionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsSpecified()!=null) return true;
			if (getPartyVersion()!=null) return true;
			if (getAsSpecified()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmVersion.SimmVersionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SimmVersion.SimmVersionBuilder o = (SimmVersion.SimmVersionBuilder) other;
			
			
			merger.mergeBasic(getIsSpecified(), o.getIsSpecified(), this::setIsSpecified);
			merger.mergeBasic(getPartyVersion(), o.getPartyVersion(), this::setPartyVersion);
			merger.mergeBasic(getAsSpecified(), o.getAsSpecified(), this::setAsSpecified);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmVersion _that = getType().cast(o);
		
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(partyVersion, _that.getPartyVersion())) return false;
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (partyVersion != null ? partyVersion.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimmVersionBuilder {" +
				"isSpecified=" + this.isSpecified + ", " +
				"partyVersion=" + this.partyVersion + ", " +
				"asSpecified=" + this.asSpecified +
			'}';
		}
	}
}
