package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.ElectricityTransmissionContingencyMeta;
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
 * Provision A structure to specify the tranmission contingency and the party that bears the obligation.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to specify the tranmission contingency and the party that bears the obligation.
 *
 */
@RosettaDataType(value="ElectricityTransmissionContingency", builder=ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityTransmissionContingency", model="fpml", builder=ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilderImpl.class, version="2.1.1")
public interface ElectricityTransmissionContingency extends RosettaModelObject {

	ElectricityTransmissionContingencyMeta metaData = new ElectricityTransmissionContingencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The conditions under which the party specified in contingentParty will be excused from damages if transmission is interrupted or curtailed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The conditions under which the party specified in contingentParty will be excused from damages if transmission is interrupted or curtailed.
	 *
	 */
	ElectricityTransmissionContingencyType getContingency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party to which the contingency applies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party to which the contingency applies.
	 *
	 */
	List<? extends PartyReference> getContingentParty();

	/*********************** Build Methods  ***********************/
	ElectricityTransmissionContingency build();
	
	ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder toBuilder();
	
	static ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder builder() {
		return new ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityTransmissionContingency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityTransmissionContingency> getType() {
		return ElectricityTransmissionContingency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contingency"), processor, ElectricityTransmissionContingencyType.class, getContingency());
		processRosetta(path.newSubPath("contingentParty"), processor, PartyReference.class, getContingentParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityTransmissionContingencyBuilder extends ElectricityTransmissionContingency, RosettaModelObjectBuilder {
		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder getOrCreateContingency();
		@Override
		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder getContingency();
		PartyReference.PartyReferenceBuilder getOrCreateContingentParty(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getContingentParty();
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder setContingency(ElectricityTransmissionContingencyType contingency);
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(PartyReference contingentParty);
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(PartyReference contingentParty, int idx);
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(List<? extends PartyReference> contingentParty);
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder setContingentParty(List<? extends PartyReference> contingentParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contingency"), processor, ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder.class, getContingency());
			processRosetta(path.newSubPath("contingentParty"), processor, PartyReference.PartyReferenceBuilder.class, getContingentParty());
		}
		

		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityTransmissionContingency  ***********************/
	class ElectricityTransmissionContingencyImpl implements ElectricityTransmissionContingency {
		private final ElectricityTransmissionContingencyType contingency;
		private final List<? extends PartyReference> contingentParty;
		
		protected ElectricityTransmissionContingencyImpl(ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder builder) {
			this.contingency = ofNullable(builder.getContingency()).map(f->f.build()).orElse(null);
			this.contingentParty = ofNullable(builder.getContingentParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("contingency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contingency")
		public ElectricityTransmissionContingencyType getContingency() {
			return contingency;
		}
		
		@Override
		@RosettaAttribute("contingentParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contingentParty")
		public List<? extends PartyReference> getContingentParty() {
			return contingentParty;
		}
		
		@Override
		public ElectricityTransmissionContingency build() {
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder toBuilder() {
			ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder builder) {
			ofNullable(getContingency()).ifPresent(builder::setContingency);
			ofNullable(getContingentParty()).ifPresent(builder::setContingentParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityTransmissionContingency _that = getType().cast(o);
		
			if (!Objects.equals(contingency, _that.getContingency())) return false;
			if (!ListEquals.listEquals(contingentParty, _that.getContingentParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contingency != null ? contingency.hashCode() : 0);
			_result = 31 * _result + (contingentParty != null ? contingentParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityTransmissionContingency {" +
				"contingency=" + this.contingency + ", " +
				"contingentParty=" + this.contingentParty +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityTransmissionContingency  ***********************/
	class ElectricityTransmissionContingencyBuilderImpl implements ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder {
	
		protected ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder contingency;
		protected List<PartyReference.PartyReferenceBuilder> contingentParty = new ArrayList<>();
		
		@Override
		@RosettaAttribute("contingency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contingency")
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder getContingency() {
			return contingency;
		}
		
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder getOrCreateContingency() {
			ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder result;
			if (contingency!=null) {
				result = contingency;
			}
			else {
				result = contingency = ElectricityTransmissionContingencyType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contingentParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contingentParty")
		public List<? extends PartyReference.PartyReferenceBuilder> getContingentParty() {
			return contingentParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateContingentParty(int index) {
			if (contingentParty==null) {
				this.contingentParty = new ArrayList<>();
			}
			return getIndex(contingentParty, index, () -> {
						PartyReference.PartyReferenceBuilder newContingentParty = PartyReference.builder();
						return newContingentParty;
					});
		}
		
		@RosettaAttribute("contingency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contingency")
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder setContingency(ElectricityTransmissionContingencyType _contingency) {
			this.contingency = _contingency == null ? null : _contingency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contingentParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contingentParty")
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(PartyReference _contingentParty) {
			if (_contingentParty != null) {
				this.contingentParty.add(_contingentParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(PartyReference _contingentParty, int idx) {
			getIndex(this.contingentParty, idx, () -> _contingentParty.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder addContingentParty(List<? extends PartyReference> contingentPartys) {
			if (contingentPartys != null) {
				for (final PartyReference toAdd : contingentPartys) {
					this.contingentParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contingentParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contingentParty")
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder setContingentParty(List<? extends PartyReference> contingentPartys) {
			if (contingentPartys == null) {
				this.contingentParty = new ArrayList<>();
			} else {
				this.contingentParty = contingentPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingency build() {
			return new ElectricityTransmissionContingency.ElectricityTransmissionContingencyImpl(this);
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder prune() {
			if (contingency!=null && !contingency.prune().hasData()) contingency = null;
			contingentParty = contingentParty.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContingency()!=null && getContingency().hasData()) return true;
			if (getContingentParty()!=null && getContingentParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder o = (ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder) other;
			
			merger.mergeRosetta(getContingency(), o.getContingency(), this::setContingency);
			merger.mergeRosetta(getContingentParty(), o.getContingentParty(), this::getOrCreateContingentParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityTransmissionContingency _that = getType().cast(o);
		
			if (!Objects.equals(contingency, _that.getContingency())) return false;
			if (!ListEquals.listEquals(contingentParty, _that.getContingentParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contingency != null ? contingency.hashCode() : 0);
			_result = 31 * _result + (contingentParty != null ? contingentParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityTransmissionContingencyBuilder {" +
				"contingency=" + this.contingency + ", " +
				"contingentParty=" + this.contingentParty +
			'}';
		}
	}
}
