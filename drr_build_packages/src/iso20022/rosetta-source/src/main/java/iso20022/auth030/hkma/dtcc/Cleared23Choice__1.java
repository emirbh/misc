package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.Cleared23Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates whether the contract was cleared, not cleared or if the contract is intended to be cleared.
 * @version ${project.version}
 */
@RosettaDataType(value="Cleared23Choice__1", builder=Cleared23Choice__1.Cleared23Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Cleared23Choice__1", model="iso20022", builder=Cleared23Choice__1.Cleared23Choice__1BuilderImpl.class, version="${project.version}")
public interface Cleared23Choice__1 extends RosettaModelObject {

	Cleared23Choice__1Meta metaData = new Cleared23Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that the contract has been cleared.
	 */
	ClearingPartyAndTime21Choice__1 getClrd();
	/**
	 * Indicates that the contract is intended to be cleared.
	 */
	ClearingPartyAndTime22Choice__1 getIntndToClear();
	/**
	 * Indicates that the contract has not been cleared.
	 */
	ClearingExceptionOrExemption3Choice__1 getNonClrd();

	/*********************** Build Methods  ***********************/
	Cleared23Choice__1 build();
	
	Cleared23Choice__1.Cleared23Choice__1Builder toBuilder();
	
	static Cleared23Choice__1.Cleared23Choice__1Builder builder() {
		return new Cleared23Choice__1.Cleared23Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Cleared23Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Cleared23Choice__1> getType() {
		return Cleared23Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("clrd"), processor, ClearingPartyAndTime21Choice__1.class, getClrd());
		processRosetta(path.newSubPath("intndToClear"), processor, ClearingPartyAndTime22Choice__1.class, getIntndToClear());
		processRosetta(path.newSubPath("nonClrd"), processor, ClearingExceptionOrExemption3Choice__1.class, getNonClrd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Cleared23Choice__1Builder extends Cleared23Choice__1, RosettaModelObjectBuilder {
		ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder getOrCreateClrd();
		@Override
		ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder getClrd();
		ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder getOrCreateIntndToClear();
		@Override
		ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder getIntndToClear();
		ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder getOrCreateNonClrd();
		@Override
		ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder getNonClrd();
		Cleared23Choice__1.Cleared23Choice__1Builder setClrd(ClearingPartyAndTime21Choice__1 clrd);
		Cleared23Choice__1.Cleared23Choice__1Builder setIntndToClear(ClearingPartyAndTime22Choice__1 intndToClear);
		Cleared23Choice__1.Cleared23Choice__1Builder setNonClrd(ClearingExceptionOrExemption3Choice__1 nonClrd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("clrd"), processor, ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder.class, getClrd());
			processRosetta(path.newSubPath("intndToClear"), processor, ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder.class, getIntndToClear());
			processRosetta(path.newSubPath("nonClrd"), processor, ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder.class, getNonClrd());
		}
		

		Cleared23Choice__1.Cleared23Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of Cleared23Choice__1  ***********************/
	class Cleared23Choice__1Impl implements Cleared23Choice__1 {
		private final ClearingPartyAndTime21Choice__1 clrd;
		private final ClearingPartyAndTime22Choice__1 intndToClear;
		private final ClearingExceptionOrExemption3Choice__1 nonClrd;
		
		protected Cleared23Choice__1Impl(Cleared23Choice__1.Cleared23Choice__1Builder builder) {
			this.clrd = ofNullable(builder.getClrd()).map(f->f.build()).orElse(null);
			this.intndToClear = ofNullable(builder.getIntndToClear()).map(f->f.build()).orElse(null);
			this.nonClrd = ofNullable(builder.getNonClrd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrd")
		public ClearingPartyAndTime21Choice__1 getClrd() {
			return clrd;
		}
		
		@Override
		@RosettaAttribute("intndToClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intndToClear")
		public ClearingPartyAndTime22Choice__1 getIntndToClear() {
			return intndToClear;
		}
		
		@Override
		@RosettaAttribute("nonClrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonClrd")
		public ClearingExceptionOrExemption3Choice__1 getNonClrd() {
			return nonClrd;
		}
		
		@Override
		public Cleared23Choice__1 build() {
			return this;
		}
		
		@Override
		public Cleared23Choice__1.Cleared23Choice__1Builder toBuilder() {
			Cleared23Choice__1.Cleared23Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Cleared23Choice__1.Cleared23Choice__1Builder builder) {
			ofNullable(getClrd()).ifPresent(builder::setClrd);
			ofNullable(getIntndToClear()).ifPresent(builder::setIntndToClear);
			ofNullable(getNonClrd()).ifPresent(builder::setNonClrd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Cleared23Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(clrd, _that.getClrd())) return false;
			if (!Objects.equals(intndToClear, _that.getIntndToClear())) return false;
			if (!Objects.equals(nonClrd, _that.getNonClrd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clrd != null ? clrd.hashCode() : 0);
			_result = 31 * _result + (intndToClear != null ? intndToClear.hashCode() : 0);
			_result = 31 * _result + (nonClrd != null ? nonClrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Cleared23Choice__1 {" +
				"clrd=" + this.clrd + ", " +
				"intndToClear=" + this.intndToClear + ", " +
				"nonClrd=" + this.nonClrd +
			'}';
		}
	}

	/*********************** Builder Implementation of Cleared23Choice__1  ***********************/
	class Cleared23Choice__1BuilderImpl implements Cleared23Choice__1.Cleared23Choice__1Builder {
	
		protected ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder clrd;
		protected ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder intndToClear;
		protected ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder nonClrd;
		
		@Override
		@RosettaAttribute("clrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrd")
		public ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder getClrd() {
			return clrd;
		}
		
		@Override
		public ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder getOrCreateClrd() {
			ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder result;
			if (clrd!=null) {
				result = clrd;
			}
			else {
				result = clrd = ClearingPartyAndTime21Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intndToClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intndToClear")
		public ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder getIntndToClear() {
			return intndToClear;
		}
		
		@Override
		public ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder getOrCreateIntndToClear() {
			ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder result;
			if (intndToClear!=null) {
				result = intndToClear;
			}
			else {
				result = intndToClear = ClearingPartyAndTime22Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonClrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonClrd")
		public ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder getNonClrd() {
			return nonClrd;
		}
		
		@Override
		public ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder getOrCreateNonClrd() {
			ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder result;
			if (nonClrd!=null) {
				result = nonClrd;
			}
			else {
				result = nonClrd = ClearingExceptionOrExemption3Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("clrd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrd")
		@Override
		public Cleared23Choice__1.Cleared23Choice__1Builder setClrd(ClearingPartyAndTime21Choice__1 _clrd) {
			this.clrd = _clrd == null ? null : _clrd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intndToClear")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intndToClear")
		@Override
		public Cleared23Choice__1.Cleared23Choice__1Builder setIntndToClear(ClearingPartyAndTime22Choice__1 _intndToClear) {
			this.intndToClear = _intndToClear == null ? null : _intndToClear.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonClrd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonClrd")
		@Override
		public Cleared23Choice__1.Cleared23Choice__1Builder setNonClrd(ClearingExceptionOrExemption3Choice__1 _nonClrd) {
			this.nonClrd = _nonClrd == null ? null : _nonClrd.toBuilder();
			return this;
		}
		
		@Override
		public Cleared23Choice__1 build() {
			return new Cleared23Choice__1.Cleared23Choice__1Impl(this);
		}
		
		@Override
		public Cleared23Choice__1.Cleared23Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cleared23Choice__1.Cleared23Choice__1Builder prune() {
			if (clrd!=null && !clrd.prune().hasData()) clrd = null;
			if (intndToClear!=null && !intndToClear.prune().hasData()) intndToClear = null;
			if (nonClrd!=null && !nonClrd.prune().hasData()) nonClrd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getClrd()!=null && getClrd().hasData()) return true;
			if (getIntndToClear()!=null && getIntndToClear().hasData()) return true;
			if (getNonClrd()!=null && getNonClrd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cleared23Choice__1.Cleared23Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Cleared23Choice__1.Cleared23Choice__1Builder o = (Cleared23Choice__1.Cleared23Choice__1Builder) other;
			
			merger.mergeRosetta(getClrd(), o.getClrd(), this::setClrd);
			merger.mergeRosetta(getIntndToClear(), o.getIntndToClear(), this::setIntndToClear);
			merger.mergeRosetta(getNonClrd(), o.getNonClrd(), this::setNonClrd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Cleared23Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(clrd, _that.getClrd())) return false;
			if (!Objects.equals(intndToClear, _that.getIntndToClear())) return false;
			if (!Objects.equals(nonClrd, _that.getNonClrd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clrd != null ? clrd.hashCode() : 0);
			_result = 31 * _result + (intndToClear != null ? intndToClear.hashCode() : 0);
			_result = 31 * _result + (nonClrd != null ? nonClrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Cleared23Choice__1Builder {" +
				"clrd=" + this.clrd + ", " +
				"intndToClear=" + this.intndToClear + ", " +
				"nonClrd=" + this.nonClrd +
			'}';
		}
	}
}
