package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.PartyPortfolioNameMeta;
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
 * Provision A type to represent a portfolio name for a particular party.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to represent a portfolio name for a particular party.
 *
 */
@RosettaDataType(value="PartyPortfolioName", builder=PartyPortfolioName.PartyPortfolioNameBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyPortfolioName", model="fpml", builder=PartyPortfolioName.PartyPortfolioNameBuilderImpl.class, version="2.1.1")
public interface PartyPortfolioName extends RosettaModelObject {

	PartyPortfolioNameMeta metaData = new PartyPortfolioNameMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. The party referenced has allocated the trade identifier.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. The party referenced has allocated the trade identifier.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends PortfolioName> getPortfolioName();

	/*********************** Build Methods  ***********************/
	PartyPortfolioName build();
	
	PartyPortfolioName.PartyPortfolioNameBuilder toBuilder();
	
	static PartyPortfolioName.PartyPortfolioNameBuilder builder() {
		return new PartyPortfolioName.PartyPortfolioNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyPortfolioName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyPortfolioName> getType() {
		return PartyPortfolioName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.class, getPortfolioName());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyPortfolioNameBuilder extends PartyPortfolioName, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		PortfolioName.PortfolioNameBuilder getOrCreatePortfolioName(int index);
		@Override
		List<? extends PortfolioName.PortfolioNameBuilder> getPortfolioName();
		PartyPortfolioName.PartyPortfolioNameBuilder setId(String id);
		PartyPortfolioName.PartyPortfolioNameBuilder setPartyReference(PartyReference partyReference);
		PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(PortfolioName portfolioName);
		PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(PortfolioName portfolioName, int idx);
		PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(List<? extends PortfolioName> portfolioName);
		PartyPortfolioName.PartyPortfolioNameBuilder setPortfolioName(List<? extends PortfolioName> portfolioName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.PortfolioNameBuilder.class, getPortfolioName());
		}
		

		PartyPortfolioName.PartyPortfolioNameBuilder prune();
	}

	/*********************** Immutable Implementation of PartyPortfolioName  ***********************/
	class PartyPortfolioNameImpl implements PartyPortfolioName {
		private final String id;
		private final PartyReference partyReference;
		private final List<? extends PortfolioName> portfolioName;
		
		protected PartyPortfolioNameImpl(PartyPortfolioName.PartyPortfolioNameBuilder builder) {
			this.id = builder.getId();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.portfolioName = ofNullable(builder.getPortfolioName()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("portfolioName")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("portfolioName")
		public List<? extends PortfolioName> getPortfolioName() {
			return portfolioName;
		}
		
		@Override
		public PartyPortfolioName build() {
			return this;
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder toBuilder() {
			PartyPortfolioName.PartyPortfolioNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyPortfolioName.PartyPortfolioNameBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getPortfolioName()).ifPresent(builder::setPortfolioName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyPortfolioName _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(portfolioName, _that.getPortfolioName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (portfolioName != null ? portfolioName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyPortfolioName {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"portfolioName=" + this.portfolioName +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyPortfolioName  ***********************/
	class PartyPortfolioNameBuilderImpl implements PartyPortfolioName.PartyPortfolioNameBuilder {
	
		protected String id;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<PortfolioName.PortfolioNameBuilder> portfolioName = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioName")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("portfolioName")
		public List<? extends PortfolioName.PortfolioNameBuilder> getPortfolioName() {
			return portfolioName;
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder getOrCreatePortfolioName(int index) {
			if (portfolioName==null) {
				this.portfolioName = new ArrayList<>();
			}
			return getIndex(portfolioName, index, () -> {
						PortfolioName.PortfolioNameBuilder newPortfolioName = PortfolioName.builder();
						return newPortfolioName;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("portfolioName")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("portfolioName")
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(PortfolioName _portfolioName) {
			if (_portfolioName != null) {
				this.portfolioName.add(_portfolioName.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(PortfolioName _portfolioName, int idx) {
			getIndex(this.portfolioName, idx, () -> _portfolioName.toBuilder());
			return this;
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(List<? extends PortfolioName> portfolioNames) {
			if (portfolioNames != null) {
				for (final PortfolioName toAdd : portfolioNames) {
					this.portfolioName.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("portfolioName")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("portfolioName")
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder setPortfolioName(List<? extends PortfolioName> portfolioNames) {
			if (portfolioNames == null) {
				this.portfolioName = new ArrayList<>();
			} else {
				this.portfolioName = portfolioNames.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyPortfolioName build() {
			return new PartyPortfolioName.PartyPortfolioNameImpl(this);
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			portfolioName = portfolioName.stream().filter(b->b!=null).<PortfolioName.PortfolioNameBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getPortfolioName()!=null && getPortfolioName().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyPortfolioName.PartyPortfolioNameBuilder o = (PartyPortfolioName.PartyPortfolioNameBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getPortfolioName(), o.getPortfolioName(), this::getOrCreatePortfolioName);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyPortfolioName _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(portfolioName, _that.getPortfolioName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (portfolioName != null ? portfolioName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyPortfolioNameBuilder {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"portfolioName=" + this.portfolioName +
			'}';
		}
	}
}
