package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.RegulatorApplicabilityMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision Speccifies the trade is subject to this regulation.
 *
 */
@RosettaDataType(value="RegulatorApplicability", builder=RegulatorApplicability.RegulatorApplicabilityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatorApplicability", model="fpml", builder=RegulatorApplicability.RegulatorApplicabilityBuilderImpl.class, version="2.1.1")
public interface RegulatorApplicability extends RosettaModelObject {

	RegulatorApplicabilityMeta metaData = new RegulatorApplicabilityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getSupervisoryBody();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends RegulationName> getRegulation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the reporting party.
	 *
	 */
	PartyReference getReportingPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the reporting party.
	 *
	 */
	PartyReference getCounterPartyReference();

	/*********************** Build Methods  ***********************/
	RegulatorApplicability build();
	
	RegulatorApplicability.RegulatorApplicabilityBuilder toBuilder();
	
	static RegulatorApplicability.RegulatorApplicabilityBuilder builder() {
		return new RegulatorApplicability.RegulatorApplicabilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatorApplicability> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatorApplicability> getType() {
		return RegulatorApplicability.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("regulation"), processor, RegulationName.class, getRegulation());
		processRosetta(path.newSubPath("reportingPartyReference"), processor, PartyReference.class, getReportingPartyReference());
		processRosetta(path.newSubPath("counterPartyReference"), processor, PartyReference.class, getCounterPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatorApplicabilityBuilder extends RegulatorApplicability, RosettaModelObjectBuilder {
		RegulationName.RegulationNameBuilder getOrCreateRegulation(int index);
		@Override
		List<? extends RegulationName.RegulationNameBuilder> getRegulation();
		PartyReference.PartyReferenceBuilder getOrCreateReportingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReportingPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateCounterPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getCounterPartyReference();
		RegulatorApplicability.RegulatorApplicabilityBuilder setSupervisoryBody(String supervisoryBody);
		RegulatorApplicability.RegulatorApplicabilityBuilder addRegulation(RegulationName regulation);
		RegulatorApplicability.RegulatorApplicabilityBuilder addRegulation(RegulationName regulation, int idx);
		RegulatorApplicability.RegulatorApplicabilityBuilder addRegulation(List<? extends RegulationName> regulation);
		RegulatorApplicability.RegulatorApplicabilityBuilder setRegulation(List<? extends RegulationName> regulation);
		RegulatorApplicability.RegulatorApplicabilityBuilder setReportingPartyReference(PartyReference reportingPartyReference);
		RegulatorApplicability.RegulatorApplicabilityBuilder setCounterPartyReference(PartyReference counterPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("regulation"), processor, RegulationName.RegulationNameBuilder.class, getRegulation());
			processRosetta(path.newSubPath("reportingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReportingPartyReference());
			processRosetta(path.newSubPath("counterPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCounterPartyReference());
		}
		

		RegulatorApplicability.RegulatorApplicabilityBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatorApplicability  ***********************/
	class RegulatorApplicabilityImpl implements RegulatorApplicability {
		private final String supervisoryBody;
		private final List<? extends RegulationName> regulation;
		private final PartyReference reportingPartyReference;
		private final PartyReference counterPartyReference;
		
		protected RegulatorApplicabilityImpl(RegulatorApplicability.RegulatorApplicabilityBuilder builder) {
			this.supervisoryBody = builder.getSupervisoryBody();
			this.regulation = ofNullable(builder.getRegulation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingPartyReference = ofNullable(builder.getReportingPartyReference()).map(f->f.build()).orElse(null);
			this.counterPartyReference = ofNullable(builder.getCounterPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBody")
		public String getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("regulation")
		public List<? extends RegulationName> getRegulation() {
			return regulation;
		}
		
		@Override
		@RosettaAttribute("reportingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingPartyReference")
		public PartyReference getReportingPartyReference() {
			return reportingPartyReference;
		}
		
		@Override
		@RosettaAttribute("counterPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyReference")
		public PartyReference getCounterPartyReference() {
			return counterPartyReference;
		}
		
		@Override
		public RegulatorApplicability build() {
			return this;
		}
		
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder toBuilder() {
			RegulatorApplicability.RegulatorApplicabilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatorApplicability.RegulatorApplicabilityBuilder builder) {
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getRegulation()).ifPresent(builder::setRegulation);
			ofNullable(getReportingPartyReference()).ifPresent(builder::setReportingPartyReference);
			ofNullable(getCounterPartyReference()).ifPresent(builder::setCounterPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatorApplicability _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!ListEquals.listEquals(regulation, _that.getRegulation())) return false;
			if (!Objects.equals(reportingPartyReference, _that.getReportingPartyReference())) return false;
			if (!Objects.equals(counterPartyReference, _that.getCounterPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (regulation != null ? regulation.hashCode() : 0);
			_result = 31 * _result + (reportingPartyReference != null ? reportingPartyReference.hashCode() : 0);
			_result = 31 * _result + (counterPartyReference != null ? counterPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatorApplicability {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"regulation=" + this.regulation + ", " +
				"reportingPartyReference=" + this.reportingPartyReference + ", " +
				"counterPartyReference=" + this.counterPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatorApplicability  ***********************/
	class RegulatorApplicabilityBuilderImpl implements RegulatorApplicability.RegulatorApplicabilityBuilder {
	
		protected String supervisoryBody;
		protected List<RegulationName.RegulationNameBuilder> regulation = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder reportingPartyReference;
		protected PartyReference.PartyReferenceBuilder counterPartyReference;
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBody")
		public String getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("regulation")
		public List<? extends RegulationName.RegulationNameBuilder> getRegulation() {
			return regulation;
		}
		
		@Override
		public RegulationName.RegulationNameBuilder getOrCreateRegulation(int index) {
			if (regulation==null) {
				this.regulation = new ArrayList<>();
			}
			return getIndex(regulation, index, () -> {
						RegulationName.RegulationNameBuilder newRegulation = RegulationName.builder();
						return newRegulation;
					});
		}
		
		@Override
		@RosettaAttribute("reportingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingPartyReference")
		public PartyReference.PartyReferenceBuilder getReportingPartyReference() {
			return reportingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReportingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (reportingPartyReference!=null) {
				result = reportingPartyReference;
			}
			else {
				result = reportingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyReference")
		public PartyReference.PartyReferenceBuilder getCounterPartyReference() {
			return counterPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCounterPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (counterPartyReference!=null) {
				result = counterPartyReference;
			}
			else {
				result = counterPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder setSupervisoryBody(String _supervisoryBody) {
			this.supervisoryBody = _supervisoryBody == null ? null : _supervisoryBody;
			return this;
		}
		
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("regulation")
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder addRegulation(RegulationName _regulation) {
			if (_regulation != null) {
				this.regulation.add(_regulation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder addRegulation(RegulationName _regulation, int idx) {
			getIndex(this.regulation, idx, () -> _regulation.toBuilder());
			return this;
		}
		
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder addRegulation(List<? extends RegulationName> regulations) {
			if (regulations != null) {
				for (final RegulationName toAdd : regulations) {
					this.regulation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("regulation")
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder setRegulation(List<? extends RegulationName> regulations) {
			if (regulations == null) {
				this.regulation = new ArrayList<>();
			} else {
				this.regulation = regulations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingPartyReference")
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder setReportingPartyReference(PartyReference _reportingPartyReference) {
			this.reportingPartyReference = _reportingPartyReference == null ? null : _reportingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterPartyReference")
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder setCounterPartyReference(PartyReference _counterPartyReference) {
			this.counterPartyReference = _counterPartyReference == null ? null : _counterPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public RegulatorApplicability build() {
			return new RegulatorApplicability.RegulatorApplicabilityImpl(this);
		}
		
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder prune() {
			regulation = regulation.stream().filter(b->b!=null).<RegulationName.RegulationNameBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reportingPartyReference!=null && !reportingPartyReference.prune().hasData()) reportingPartyReference = null;
			if (counterPartyReference!=null && !counterPartyReference.prune().hasData()) counterPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSupervisoryBody()!=null) return true;
			if (getRegulation()!=null && getRegulation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingPartyReference()!=null && getReportingPartyReference().hasData()) return true;
			if (getCounterPartyReference()!=null && getCounterPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatorApplicability.RegulatorApplicabilityBuilder o = (RegulatorApplicability.RegulatorApplicabilityBuilder) other;
			
			merger.mergeRosetta(getRegulation(), o.getRegulation(), this::getOrCreateRegulation);
			merger.mergeRosetta(getReportingPartyReference(), o.getReportingPartyReference(), this::setReportingPartyReference);
			merger.mergeRosetta(getCounterPartyReference(), o.getCounterPartyReference(), this::setCounterPartyReference);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatorApplicability _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!ListEquals.listEquals(regulation, _that.getRegulation())) return false;
			if (!Objects.equals(reportingPartyReference, _that.getReportingPartyReference())) return false;
			if (!Objects.equals(counterPartyReference, _that.getCounterPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (regulation != null ? regulation.hashCode() : 0);
			_result = 31 * _result + (reportingPartyReference != null ? reportingPartyReference.hashCode() : 0);
			_result = 31 * _result + (counterPartyReference != null ? counterPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatorApplicabilityBuilder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"regulation=" + this.regulation + ", " +
				"reportingPartyReference=" + this.reportingPartyReference + ", " +
				"counterPartyReference=" + this.counterPartyReference +
			'}';
		}
	}
}
