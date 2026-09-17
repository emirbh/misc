package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.SecurityProviderRightsEventMeta;
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
 * A class to specify the Pledgor/Obligor/Chargor Rights Event election.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(j)" * name "Chargor Rights Event"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(j)" * name "Obligor Rights Event"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(j)" * name "Pledgor Rights Event."
 *
 * Provision 
 *
 */
@RosettaDataType(value="SecurityProviderRightsEvent", builder=SecurityProviderRightsEvent.SecurityProviderRightsEventBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SecurityProviderRightsEvent", model="cdm", builder=SecurityProviderRightsEvent.SecurityProviderRightsEventBuilderImpl.class, version="6.23.0")
public interface SecurityProviderRightsEvent extends RosettaModelObject {

	SecurityProviderRightsEventMeta metaData = new SecurityProviderRightsEventMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends SecurityProviderRightsEventElection> getPartyElection();
	/**
	 * The Pledgor/Obligor/Chargor Rights Event election includes cooling off language when the attribute is set of True.
	 */
	Boolean getIncludeCoolingOffLanguage();
	/**
	 * If specified as applicable here, a Pledgor/Obligor/Chargor Rights Event will not occur unless the Pledgor/Obligor/Chargor (A) has provided a statement to the Secured Party in respect of such Early Termination Date.
	 */
	Boolean getFullDischarge();
	/**
	 * The Automatic Set-Off provision applies when the value is set to True.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(l)" * name "Modification to Obligors Rights and Remedies"
	 *
	 * Provision 
	 *
	 */
	Boolean getAutomaticSetOff();
	/**
	 * A custom Pledgor/Obligor/Chargor Rights Event election might be specified by the parties.
	 */
	String getCustomElection();

	/*********************** Build Methods  ***********************/
	SecurityProviderRightsEvent build();
	
	SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder toBuilder();
	
	static SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder builder() {
		return new SecurityProviderRightsEvent.SecurityProviderRightsEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityProviderRightsEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityProviderRightsEvent> getType() {
		return SecurityProviderRightsEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, SecurityProviderRightsEventElection.class, getPartyElection());
		processor.processBasic(path.newSubPath("includeCoolingOffLanguage"), Boolean.class, getIncludeCoolingOffLanguage(), this);
		processor.processBasic(path.newSubPath("fullDischarge"), Boolean.class, getFullDischarge(), this);
		processor.processBasic(path.newSubPath("automaticSetOff"), Boolean.class, getAutomaticSetOff(), this);
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityProviderRightsEventBuilder extends SecurityProviderRightsEvent, RosettaModelObjectBuilder {
		SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder> getPartyElection();
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(SecurityProviderRightsEventElection partyElection);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(SecurityProviderRightsEventElection partyElection, int idx);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(List<? extends SecurityProviderRightsEventElection> partyElection);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setPartyElection(List<? extends SecurityProviderRightsEventElection> partyElection);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setIncludeCoolingOffLanguage(Boolean includeCoolingOffLanguage);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setFullDischarge(Boolean fullDischarge);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setAutomaticSetOff(Boolean automaticSetOff);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setCustomElection(String customElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder.class, getPartyElection());
			processor.processBasic(path.newSubPath("includeCoolingOffLanguage"), Boolean.class, getIncludeCoolingOffLanguage(), this);
			processor.processBasic(path.newSubPath("fullDischarge"), Boolean.class, getFullDischarge(), this);
			processor.processBasic(path.newSubPath("automaticSetOff"), Boolean.class, getAutomaticSetOff(), this);
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		}
		

		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder prune();
	}

	/*********************** Immutable Implementation of SecurityProviderRightsEvent  ***********************/
	class SecurityProviderRightsEventImpl implements SecurityProviderRightsEvent {
		private final List<? extends SecurityProviderRightsEventElection> partyElection;
		private final Boolean includeCoolingOffLanguage;
		private final Boolean fullDischarge;
		private final Boolean automaticSetOff;
		private final String customElection;
		
		protected SecurityProviderRightsEventImpl(SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.includeCoolingOffLanguage = builder.getIncludeCoolingOffLanguage();
			this.fullDischarge = builder.getFullDischarge();
			this.automaticSetOff = builder.getAutomaticSetOff();
			this.customElection = builder.getCustomElection();
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends SecurityProviderRightsEventElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		@RosettaAttribute("includeCoolingOffLanguage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("includeCoolingOffLanguage")
		public Boolean getIncludeCoolingOffLanguage() {
			return includeCoolingOffLanguage;
		}
		
		@Override
		@RosettaAttribute("fullDischarge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullDischarge")
		public Boolean getFullDischarge() {
			return fullDischarge;
		}
		
		@Override
		@RosettaAttribute("automaticSetOff")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticSetOff")
		public Boolean getAutomaticSetOff() {
			return automaticSetOff;
		}
		
		@Override
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customElection")
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public SecurityProviderRightsEvent build() {
			return this;
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder toBuilder() {
			SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
			ofNullable(getIncludeCoolingOffLanguage()).ifPresent(builder::setIncludeCoolingOffLanguage);
			ofNullable(getFullDischarge()).ifPresent(builder::setFullDischarge);
			ofNullable(getAutomaticSetOff()).ifPresent(builder::setAutomaticSetOff);
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityProviderRightsEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(includeCoolingOffLanguage, _that.getIncludeCoolingOffLanguage())) return false;
			if (!Objects.equals(fullDischarge, _that.getFullDischarge())) return false;
			if (!Objects.equals(automaticSetOff, _that.getAutomaticSetOff())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (includeCoolingOffLanguage != null ? includeCoolingOffLanguage.hashCode() : 0);
			_result = 31 * _result + (fullDischarge != null ? fullDischarge.hashCode() : 0);
			_result = 31 * _result + (automaticSetOff != null ? automaticSetOff.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityProviderRightsEvent {" +
				"partyElection=" + this.partyElection + ", " +
				"includeCoolingOffLanguage=" + this.includeCoolingOffLanguage + ", " +
				"fullDischarge=" + this.fullDischarge + ", " +
				"automaticSetOff=" + this.automaticSetOff + ", " +
				"customElection=" + this.customElection +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityProviderRightsEvent  ***********************/
	class SecurityProviderRightsEventBuilderImpl implements SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder {
	
		protected List<SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder> partyElection = new ArrayList<>();
		protected Boolean includeCoolingOffLanguage;
		protected Boolean fullDischarge;
		protected Boolean automaticSetOff;
		protected String customElection;
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder newPartyElection = SecurityProviderRightsEventElection.builder();
						return newPartyElection;
					});
		}
		
		@Override
		@RosettaAttribute("includeCoolingOffLanguage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("includeCoolingOffLanguage")
		public Boolean getIncludeCoolingOffLanguage() {
			return includeCoolingOffLanguage;
		}
		
		@Override
		@RosettaAttribute("fullDischarge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullDischarge")
		public Boolean getFullDischarge() {
			return fullDischarge;
		}
		
		@Override
		@RosettaAttribute("automaticSetOff")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticSetOff")
		public Boolean getAutomaticSetOff() {
			return automaticSetOff;
		}
		
		@Override
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customElection")
		public String getCustomElection() {
			return customElection;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(SecurityProviderRightsEventElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(SecurityProviderRightsEventElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(List<? extends SecurityProviderRightsEventElection> partyElections) {
			if (partyElections != null) {
				for (final SecurityProviderRightsEventElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setPartyElection(List<? extends SecurityProviderRightsEventElection> partyElections) {
			if (partyElections == null) {
				this.partyElection = new ArrayList<>();
			} else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("includeCoolingOffLanguage")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("includeCoolingOffLanguage")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setIncludeCoolingOffLanguage(Boolean _includeCoolingOffLanguage) {
			this.includeCoolingOffLanguage = _includeCoolingOffLanguage == null ? null : _includeCoolingOffLanguage;
			return this;
		}
		
		@RosettaAttribute("fullDischarge")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fullDischarge")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setFullDischarge(Boolean _fullDischarge) {
			this.fullDischarge = _fullDischarge == null ? null : _fullDischarge;
			return this;
		}
		
		@RosettaAttribute("automaticSetOff")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("automaticSetOff")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setAutomaticSetOff(Boolean _automaticSetOff) {
			this.automaticSetOff = _automaticSetOff == null ? null : _automaticSetOff;
			return this;
		}
		
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customElection")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setCustomElection(String _customElection) {
			this.customElection = _customElection == null ? null : _customElection;
			return this;
		}
		
		@Override
		public SecurityProviderRightsEvent build() {
			return new SecurityProviderRightsEvent.SecurityProviderRightsEventImpl(this);
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIncludeCoolingOffLanguage()!=null) return true;
			if (getFullDischarge()!=null) return true;
			if (getAutomaticSetOff()!=null) return true;
			if (getCustomElection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder o = (SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getIncludeCoolingOffLanguage(), o.getIncludeCoolingOffLanguage(), this::setIncludeCoolingOffLanguage);
			merger.mergeBasic(getFullDischarge(), o.getFullDischarge(), this::setFullDischarge);
			merger.mergeBasic(getAutomaticSetOff(), o.getAutomaticSetOff(), this::setAutomaticSetOff);
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityProviderRightsEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(includeCoolingOffLanguage, _that.getIncludeCoolingOffLanguage())) return false;
			if (!Objects.equals(fullDischarge, _that.getFullDischarge())) return false;
			if (!Objects.equals(automaticSetOff, _that.getAutomaticSetOff())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (includeCoolingOffLanguage != null ? includeCoolingOffLanguage.hashCode() : 0);
			_result = 31 * _result + (fullDischarge != null ? fullDischarge.hashCode() : 0);
			_result = 31 * _result + (automaticSetOff != null ? automaticSetOff.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityProviderRightsEventBuilder {" +
				"partyElection=" + this.partyElection + ", " +
				"includeCoolingOffLanguage=" + this.includeCoolingOffLanguage + ", " +
				"fullDischarge=" + this.fullDischarge + ", " +
				"automaticSetOff=" + this.automaticSetOff + ", " +
				"customElection=" + this.customElection +
			'}';
		}
	}
}
