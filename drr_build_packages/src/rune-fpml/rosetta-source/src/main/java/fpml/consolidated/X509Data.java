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
import fpml.consolidated.meta.X509DataMeta;
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
@RosettaDataType(value="X509Data", builder=X509Data.X509DataBuilderImpl.class, version="2.1.1")
@RuneDataType(value="X509Data", model="fpml", builder=X509Data.X509DataBuilderImpl.class, version="2.1.1")
public interface X509Data extends X509DataType {

	X509DataMeta metaData = new X509DataMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	X509Data build();
	
	X509Data.X509DataBuilder toBuilder();
	
	static X509Data.X509DataBuilder builder() {
		return new X509Data.X509DataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends X509Data> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends X509Data> getType() {
		return X509Data.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("x509DataTypeSequence"), processor, X509DataTypeSequence.class, getX509DataTypeSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface X509DataBuilder extends X509Data, X509DataType.X509DataTypeBuilder {
		@Override
		X509Data.X509DataBuilder addX509DataTypeSequence(X509DataTypeSequence x509DataTypeSequence);
		@Override
		X509Data.X509DataBuilder addX509DataTypeSequence(X509DataTypeSequence x509DataTypeSequence, int idx);
		@Override
		X509Data.X509DataBuilder addX509DataTypeSequence(List<? extends X509DataTypeSequence> x509DataTypeSequence);
		@Override
		X509Data.X509DataBuilder setX509DataTypeSequence(List<? extends X509DataTypeSequence> x509DataTypeSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("x509DataTypeSequence"), processor, X509DataTypeSequence.X509DataTypeSequenceBuilder.class, getX509DataTypeSequence());
		}
		

		X509Data.X509DataBuilder prune();
	}

	/*********************** Immutable Implementation of X509Data  ***********************/
	class X509DataImpl extends X509DataType.X509DataTypeImpl implements X509Data {
		
		protected X509DataImpl(X509Data.X509DataBuilder builder) {
			super(builder);
		}
		
		@Override
		public X509Data build() {
			return this;
		}
		
		@Override
		public X509Data.X509DataBuilder toBuilder() {
			X509Data.X509DataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(X509Data.X509DataBuilder builder) {
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
			return "X509Data {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of X509Data  ***********************/
	class X509DataBuilderImpl extends X509DataType.X509DataTypeBuilderImpl implements X509Data.X509DataBuilder {
	
		
		@RosettaAttribute("x509DataTypeSequence")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("x509DataTypeSequence")
		@Override
		public X509Data.X509DataBuilder addX509DataTypeSequence(X509DataTypeSequence _x509DataTypeSequence) {
			if (_x509DataTypeSequence != null) {
				this.x509DataTypeSequence.add(_x509DataTypeSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public X509Data.X509DataBuilder addX509DataTypeSequence(X509DataTypeSequence _x509DataTypeSequence, int idx) {
			getIndex(this.x509DataTypeSequence, idx, () -> _x509DataTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public X509Data.X509DataBuilder addX509DataTypeSequence(List<? extends X509DataTypeSequence> x509DataTypeSequences) {
			if (x509DataTypeSequences != null) {
				for (final X509DataTypeSequence toAdd : x509DataTypeSequences) {
					this.x509DataTypeSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("x509DataTypeSequence")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("x509DataTypeSequence")
		@Override
		public X509Data.X509DataBuilder setX509DataTypeSequence(List<? extends X509DataTypeSequence> x509DataTypeSequences) {
			if (x509DataTypeSequences == null) {
				this.x509DataTypeSequence = new ArrayList<>();
			} else {
				this.x509DataTypeSequence = x509DataTypeSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public X509Data build() {
			return new X509Data.X509DataImpl(this);
		}
		
		@Override
		public X509Data.X509DataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public X509Data.X509DataBuilder prune() {
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
		public X509Data.X509DataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			X509Data.X509DataBuilder o = (X509Data.X509DataBuilder) other;
			
			
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
			return "X509DataBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
