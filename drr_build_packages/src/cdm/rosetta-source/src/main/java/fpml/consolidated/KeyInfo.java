package fpml.consolidated;

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
import fpml.consolidated.meta.KeyInfoMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
@RosettaDataType(value="KeyInfo", builder=KeyInfo.KeyInfoBuilderImpl.class, version="2.1.1")
@RuneDataType(value="KeyInfo", model="fpml", builder=KeyInfo.KeyInfoBuilderImpl.class, version="2.1.1")
public interface KeyInfo extends KeyInfoType {

	KeyInfoMeta metaData = new KeyInfoMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	KeyInfo build();
	
	KeyInfo.KeyInfoBuilder toBuilder();
	
	static KeyInfo.KeyInfoBuilder builder() {
		return new KeyInfo.KeyInfoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyInfo> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends KeyInfo> getType() {
		return KeyInfo.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("keyInfoTypeChoice"), processor, KeyInfoTypeChoice.class, getKeyInfoTypeChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyInfoBuilder extends KeyInfo, KeyInfoType.KeyInfoTypeBuilder {
		@Override
		KeyInfo.KeyInfoBuilder setId(String id);
		@Override
		KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice);
		@Override
		KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice, int idx);
		@Override
		KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoice);
		@Override
		KeyInfo.KeyInfoBuilder setKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("keyInfoTypeChoice"), processor, KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder.class, getKeyInfoTypeChoice());
		}
		

		KeyInfo.KeyInfoBuilder prune();
	}

	/*********************** Immutable Implementation of KeyInfo  ***********************/
	class KeyInfoImpl extends KeyInfoType.KeyInfoTypeImpl implements KeyInfo {
		
		protected KeyInfoImpl(KeyInfo.KeyInfoBuilder builder) {
			super(builder);
		}
		
		@Override
		public KeyInfo build() {
			return this;
		}
		
		@Override
		public KeyInfo.KeyInfoBuilder toBuilder() {
			KeyInfo.KeyInfoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyInfo.KeyInfoBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyInfo {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of KeyInfo  ***********************/
	class KeyInfoBuilderImpl extends KeyInfoType.KeyInfoTypeBuilderImpl implements KeyInfo.KeyInfoBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public KeyInfo.KeyInfoBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("keyInfoTypeChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("keyInfoTypeChoice")
		@Override
		public KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice _keyInfoTypeChoice) {
			if (_keyInfoTypeChoice != null) {
				this.keyInfoTypeChoice.add(_keyInfoTypeChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice _keyInfoTypeChoice, int idx) {
			getIndex(this.keyInfoTypeChoice, idx, () -> _keyInfoTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoices) {
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
		public KeyInfo.KeyInfoBuilder setKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoices) {
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
		public KeyInfo build() {
			return new KeyInfo.KeyInfoImpl(this);
		}
		
		@Override
		public KeyInfo.KeyInfoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfo.KeyInfoBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfo.KeyInfoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			KeyInfo.KeyInfoBuilder o = (KeyInfo.KeyInfoBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyInfoBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
