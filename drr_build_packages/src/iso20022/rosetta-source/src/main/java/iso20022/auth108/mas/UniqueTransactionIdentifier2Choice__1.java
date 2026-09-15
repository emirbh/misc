package iso20022.auth108.mas;

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
import iso20022.auth108.mas.meta.UniqueTransactionIdentifier2Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="UniqueTransactionIdentifier2Choice__1", builder=UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="UniqueTransactionIdentifier2Choice__1", model="iso20022", builder=UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1BuilderImpl.class, version="${project.version}")
public interface UniqueTransactionIdentifier2Choice__1 extends RosettaModelObject {

	UniqueTransactionIdentifier2Choice__1Meta metaData = new UniqueTransactionIdentifier2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	String getUnqTxIdr();
	GenericIdentification175__1 getPrtry();

	/*********************** Build Methods  ***********************/
	UniqueTransactionIdentifier2Choice__1 build();
	
	UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder toBuilder();
	
	static UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder builder() {
		return new UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UniqueTransactionIdentifier2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UniqueTransactionIdentifier2Choice__1> getType() {
		return UniqueTransactionIdentifier2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unqTxIdr"), String.class, getUnqTxIdr(), this);
		processRosetta(path.newSubPath("prtry"), processor, GenericIdentification175__1.class, getPrtry());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UniqueTransactionIdentifier2Choice__1Builder extends UniqueTransactionIdentifier2Choice__1, RosettaModelObjectBuilder {
		GenericIdentification175__1.GenericIdentification175__1Builder getOrCreatePrtry();
		@Override
		GenericIdentification175__1.GenericIdentification175__1Builder getPrtry();
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder setUnqTxIdr(String unqTxIdr);
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder setPrtry(GenericIdentification175__1 prtry);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unqTxIdr"), String.class, getUnqTxIdr(), this);
			processRosetta(path.newSubPath("prtry"), processor, GenericIdentification175__1.GenericIdentification175__1Builder.class, getPrtry());
		}
		

		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of UniqueTransactionIdentifier2Choice__1  ***********************/
	class UniqueTransactionIdentifier2Choice__1Impl implements UniqueTransactionIdentifier2Choice__1 {
		private final String unqTxIdr;
		private final GenericIdentification175__1 prtry;
		
		protected UniqueTransactionIdentifier2Choice__1Impl(UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder builder) {
			this.unqTxIdr = builder.getUnqTxIdr();
			this.prtry = ofNullable(builder.getPrtry()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqTxIdr")
		public String getUnqTxIdr() {
			return unqTxIdr;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public GenericIdentification175__1 getPrtry() {
			return prtry;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1 build() {
			return this;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder toBuilder() {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder builder) {
			ofNullable(getUnqTxIdr()).ifPresent(builder::setUnqTxIdr);
			ofNullable(getPrtry()).ifPresent(builder::setPrtry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UniqueTransactionIdentifier2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(unqTxIdr, _that.getUnqTxIdr())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqTxIdr != null ? unqTxIdr.hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UniqueTransactionIdentifier2Choice__1 {" +
				"unqTxIdr=" + this.unqTxIdr + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}

	/*********************** Builder Implementation of UniqueTransactionIdentifier2Choice__1  ***********************/
	class UniqueTransactionIdentifier2Choice__1BuilderImpl implements UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder {
	
		protected String unqTxIdr;
		protected GenericIdentification175__1.GenericIdentification175__1Builder prtry;
		
		@Override
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqTxIdr")
		public String getUnqTxIdr() {
			return unqTxIdr;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public GenericIdentification175__1.GenericIdentification175__1Builder getPrtry() {
			return prtry;
		}
		
		@Override
		public GenericIdentification175__1.GenericIdentification175__1Builder getOrCreatePrtry() {
			GenericIdentification175__1.GenericIdentification175__1Builder result;
			if (prtry!=null) {
				result = prtry;
			}
			else {
				result = prtry = GenericIdentification175__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unqTxIdr")
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder setUnqTxIdr(String _unqTxIdr) {
			this.unqTxIdr = _unqTxIdr == null ? null : _unqTxIdr;
			return this;
		}
		
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtry")
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder setPrtry(GenericIdentification175__1 _prtry) {
			this.prtry = _prtry == null ? null : _prtry.toBuilder();
			return this;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1 build() {
			return new UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Impl(this);
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder prune() {
			if (prtry!=null && !prtry.prune().hasData()) prtry = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnqTxIdr()!=null) return true;
			if (getPrtry()!=null && getPrtry().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder o = (UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder) other;
			
			merger.mergeRosetta(getPrtry(), o.getPrtry(), this::setPrtry);
			
			merger.mergeBasic(getUnqTxIdr(), o.getUnqTxIdr(), this::setUnqTxIdr);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UniqueTransactionIdentifier2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(unqTxIdr, _that.getUnqTxIdr())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqTxIdr != null ? unqTxIdr.hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UniqueTransactionIdentifier2Choice__1Builder {" +
				"unqTxIdr=" + this.unqTxIdr + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}
}
