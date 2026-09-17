package fpml.consolidated;

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
import fpml.consolidated.meta.KeyInfoTypeMeta;
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
@RosettaDataType(value="KeyInfoType", builder=KeyInfoType.KeyInfoTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="KeyInfoType", model="fpml", builder=KeyInfoType.KeyInfoTypeBuilderImpl.class, version="2.1.1")
public interface KeyInfoType extends RosettaModelObject {

	KeyInfoTypeMeta metaData = new KeyInfoTypeMeta();

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
	List<? extends KeyInfoTypeChoice> getKeyInfoTypeChoice();

	/*********************** Build Methods  ***********************/
	KeyInfoType build();
	
	KeyInfoType.KeyInfoTypeBuilder toBuilder();
	
	static KeyInfoType.KeyInfoTypeBuilder builder() {
		return new KeyInfoType.KeyInfoTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyInfoType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends KeyInfoType> getType() {
		return KeyInfoType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("keyInfoTypeChoice"), processor, KeyInfoTypeChoice.class, getKeyInfoTypeChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyInfoTypeBuilder extends KeyInfoType, RosettaModelObjectBuilder {
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder getOrCreateKeyInfoTypeChoice(int index);
		@Override
		List<? extends KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder> getKeyInfoTypeChoice();
		KeyInfoType.KeyInfoTypeBuilder setId(String id);
		KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice);
		KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice, int idx);
		KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoice);
		KeyInfoType.KeyInfoTypeBuilder setKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("keyInfoTypeChoice"), processor, KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder.class, getKeyInfoTypeChoice());
		}
		

		KeyInfoType.KeyInfoTypeBuilder prune();
	}

	/*********************** Immutable Implementation of KeyInfoType  ***********************/
	class KeyInfoTypeImpl implements KeyInfoType {
		private final String id;
		private final List<? extends KeyInfoTypeChoice> keyInfoTypeChoice;
		
		protected KeyInfoTypeImpl(KeyInfoType.KeyInfoTypeBuilder builder) {
			this.id = builder.getId();
			this.keyInfoTypeChoice = ofNullable(builder.getKeyInfoTypeChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("keyInfoTypeChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("keyInfoTypeChoice")
		public List<? extends KeyInfoTypeChoice> getKeyInfoTypeChoice() {
			return keyInfoTypeChoice;
		}
		
		@Override
		public KeyInfoType build() {
			return this;
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder toBuilder() {
			KeyInfoType.KeyInfoTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyInfoType.KeyInfoTypeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getKeyInfoTypeChoice()).ifPresent(builder::setKeyInfoTypeChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyInfoType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(keyInfoTypeChoice, _that.getKeyInfoTypeChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (keyInfoTypeChoice != null ? keyInfoTypeChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyInfoType {" +
				"id=" + this.id + ", " +
				"keyInfoTypeChoice=" + this.keyInfoTypeChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of KeyInfoType  ***********************/
	class KeyInfoTypeBuilderImpl implements KeyInfoType.KeyInfoTypeBuilder {
	
		protected String id;
		protected List<KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder> keyInfoTypeChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("keyInfoTypeChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("keyInfoTypeChoice")
		public List<? extends KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder> getKeyInfoTypeChoice() {
			return keyInfoTypeChoice;
		}
		
		@Override
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder getOrCreateKeyInfoTypeChoice(int index) {
			if (keyInfoTypeChoice==null) {
				this.keyInfoTypeChoice = new ArrayList<>();
			}
			return getIndex(keyInfoTypeChoice, index, () -> {
						KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder newKeyInfoTypeChoice = KeyInfoTypeChoice.builder();
						return newKeyInfoTypeChoice;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public KeyInfoType.KeyInfoTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("keyInfoTypeChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("keyInfoTypeChoice")
		@Override
		public KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice _keyInfoTypeChoice) {
			if (_keyInfoTypeChoice != null) {
				this.keyInfoTypeChoice.add(_keyInfoTypeChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice _keyInfoTypeChoice, int idx) {
			getIndex(this.keyInfoTypeChoice, idx, () -> _keyInfoTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoices) {
			if (keyInfoTypeChoices != null) {
				for (final KeyInfoTypeChoice toAdd : keyInfoTypeChoices) {
					this.keyInfoTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("keyInfoTypeChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("keyInfoTypeChoice")
		@Override
		public KeyInfoType.KeyInfoTypeBuilder setKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoices) {
			if (keyInfoTypeChoices == null) {
				this.keyInfoTypeChoice = new ArrayList<>();
			} else {
				this.keyInfoTypeChoice = keyInfoTypeChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public KeyInfoType build() {
			return new KeyInfoType.KeyInfoTypeImpl(this);
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfoType.KeyInfoTypeBuilder prune() {
			keyInfoTypeChoice = keyInfoTypeChoice.stream().filter(b->b!=null).<KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getKeyInfoTypeChoice()!=null && getKeyInfoTypeChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfoType.KeyInfoTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			KeyInfoType.KeyInfoTypeBuilder o = (KeyInfoType.KeyInfoTypeBuilder) other;
			
			merger.mergeRosetta(getKeyInfoTypeChoice(), o.getKeyInfoTypeChoice(), this::getOrCreateKeyInfoTypeChoice);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyInfoType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(keyInfoTypeChoice, _that.getKeyInfoTypeChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (keyInfoTypeChoice != null ? keyInfoTypeChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyInfoTypeBuilder {" +
				"id=" + this.id + ", " +
				"keyInfoTypeChoice=" + this.keyInfoTypeChoice +
			'}';
		}
	}
}
