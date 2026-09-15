package fpml.consolidated;

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
import fpml.consolidated.meta.PGPDataTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
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
@RosettaDataType(value="PGPDataType", builder=PGPDataType.PGPDataTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PGPDataType", model="fpml", builder=PGPDataType.PGPDataTypeBuilderImpl.class, version="2.1.1")
public interface PGPDataType extends RosettaModelObject {

	PGPDataTypeMeta metaData = new PGPDataTypeMeta();

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
	String getPgpKeyID();
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
	String getPgpKeyPacket();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: unbounded; Namespace: ##other; Process Contents: lax.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: unbounded; Namespace: ##other; Process Contents: lax.
	 *
	 */
	List<String> getAnyContents0();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: unbounded; Namespace: ##other; Process Contents: lax.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: unbounded; Namespace: ##other; Process Contents: lax.
	 *
	 */
	List<String> getAnyContents1();

	/*********************** Build Methods  ***********************/
	PGPDataType build();
	
	PGPDataType.PGPDataTypeBuilder toBuilder();
	
	static PGPDataType.PGPDataTypeBuilder builder() {
		return new PGPDataType.PGPDataTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PGPDataType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PGPDataType> getType() {
		return PGPDataType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("pgpKeyID"), String.class, getPgpKeyID(), this);
		processor.processBasic(path.newSubPath("pgpKeyPacket"), String.class, getPgpKeyPacket(), this);
		processor.processBasic(path.newSubPath("anyContents0"), String.class, getAnyContents0(), this);
		processor.processBasic(path.newSubPath("anyContents1"), String.class, getAnyContents1(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PGPDataTypeBuilder extends PGPDataType, RosettaModelObjectBuilder {
		PGPDataType.PGPDataTypeBuilder setPgpKeyID(String pgpKeyID);
		PGPDataType.PGPDataTypeBuilder setPgpKeyPacket(String pgpKeyPacket);
		PGPDataType.PGPDataTypeBuilder addAnyContents0(String anyContents0);
		PGPDataType.PGPDataTypeBuilder addAnyContents0(String anyContents0, int idx);
		PGPDataType.PGPDataTypeBuilder addAnyContents0(List<String> anyContents0);
		PGPDataType.PGPDataTypeBuilder setAnyContents0(List<String> anyContents0);
		PGPDataType.PGPDataTypeBuilder addAnyContents1(String anyContents1);
		PGPDataType.PGPDataTypeBuilder addAnyContents1(String anyContents1, int idx);
		PGPDataType.PGPDataTypeBuilder addAnyContents1(List<String> anyContents1);
		PGPDataType.PGPDataTypeBuilder setAnyContents1(List<String> anyContents1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("pgpKeyID"), String.class, getPgpKeyID(), this);
			processor.processBasic(path.newSubPath("pgpKeyPacket"), String.class, getPgpKeyPacket(), this);
			processor.processBasic(path.newSubPath("anyContents0"), String.class, getAnyContents0(), this);
			processor.processBasic(path.newSubPath("anyContents1"), String.class, getAnyContents1(), this);
		}
		

		PGPDataType.PGPDataTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PGPDataType  ***********************/
	class PGPDataTypeImpl implements PGPDataType {
		private final String pgpKeyID;
		private final String pgpKeyPacket;
		private final List<String> anyContents0;
		private final List<String> anyContents1;
		
		protected PGPDataTypeImpl(PGPDataType.PGPDataTypeBuilder builder) {
			this.pgpKeyID = builder.getPgpKeyID();
			this.pgpKeyPacket = builder.getPgpKeyPacket();
			this.anyContents0 = ofNullable(builder.getAnyContents0()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.anyContents1 = ofNullable(builder.getAnyContents1()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pgpKeyID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pgpKeyID")
		public String getPgpKeyID() {
			return pgpKeyID;
		}
		
		@Override
		@RosettaAttribute("pgpKeyPacket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pgpKeyPacket")
		public String getPgpKeyPacket() {
			return pgpKeyPacket;
		}
		
		@Override
		@RosettaAttribute("anyContents0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("anyContents0")
		public List<String> getAnyContents0() {
			return anyContents0;
		}
		
		@Override
		@RosettaAttribute("anyContents1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("anyContents1")
		public List<String> getAnyContents1() {
			return anyContents1;
		}
		
		@Override
		public PGPDataType build() {
			return this;
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder toBuilder() {
			PGPDataType.PGPDataTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PGPDataType.PGPDataTypeBuilder builder) {
			ofNullable(getPgpKeyID()).ifPresent(builder::setPgpKeyID);
			ofNullable(getPgpKeyPacket()).ifPresent(builder::setPgpKeyPacket);
			ofNullable(getAnyContents0()).ifPresent(builder::setAnyContents0);
			ofNullable(getAnyContents1()).ifPresent(builder::setAnyContents1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PGPDataType _that = getType().cast(o);
		
			if (!Objects.equals(pgpKeyID, _that.getPgpKeyID())) return false;
			if (!Objects.equals(pgpKeyPacket, _that.getPgpKeyPacket())) return false;
			if (!ListEquals.listEquals(anyContents0, _that.getAnyContents0())) return false;
			if (!ListEquals.listEquals(anyContents1, _that.getAnyContents1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgpKeyID != null ? pgpKeyID.hashCode() : 0);
			_result = 31 * _result + (pgpKeyPacket != null ? pgpKeyPacket.hashCode() : 0);
			_result = 31 * _result + (anyContents0 != null ? anyContents0.hashCode() : 0);
			_result = 31 * _result + (anyContents1 != null ? anyContents1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PGPDataType {" +
				"pgpKeyID=" + this.pgpKeyID + ", " +
				"pgpKeyPacket=" + this.pgpKeyPacket + ", " +
				"anyContents0=" + this.anyContents0 + ", " +
				"anyContents1=" + this.anyContents1 +
			'}';
		}
	}

	/*********************** Builder Implementation of PGPDataType  ***********************/
	class PGPDataTypeBuilderImpl implements PGPDataType.PGPDataTypeBuilder {
	
		protected String pgpKeyID;
		protected String pgpKeyPacket;
		protected List<String> anyContents0 = new ArrayList<>();
		protected List<String> anyContents1 = new ArrayList<>();
		
		@Override
		@RosettaAttribute("pgpKeyID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pgpKeyID")
		public String getPgpKeyID() {
			return pgpKeyID;
		}
		
		@Override
		@RosettaAttribute("pgpKeyPacket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pgpKeyPacket")
		public String getPgpKeyPacket() {
			return pgpKeyPacket;
		}
		
		@Override
		@RosettaAttribute("anyContents0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("anyContents0")
		public List<String> getAnyContents0() {
			return anyContents0;
		}
		
		@Override
		@RosettaAttribute("anyContents1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("anyContents1")
		public List<String> getAnyContents1() {
			return anyContents1;
		}
		
		@RosettaAttribute("pgpKeyID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pgpKeyID")
		@Override
		public PGPDataType.PGPDataTypeBuilder setPgpKeyID(String _pgpKeyID) {
			this.pgpKeyID = _pgpKeyID == null ? null : _pgpKeyID;
			return this;
		}
		
		@RosettaAttribute("pgpKeyPacket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pgpKeyPacket")
		@Override
		public PGPDataType.PGPDataTypeBuilder setPgpKeyPacket(String _pgpKeyPacket) {
			this.pgpKeyPacket = _pgpKeyPacket == null ? null : _pgpKeyPacket;
			return this;
		}
		
		@RosettaAttribute("anyContents0")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents0")
		@Override
		public PGPDataType.PGPDataTypeBuilder addAnyContents0(String _anyContents0) {
			if (_anyContents0 != null) {
				this.anyContents0.add(_anyContents0);
			}
			return this;
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder addAnyContents0(String _anyContents0, int idx) {
			getIndex(this.anyContents0, idx, () -> _anyContents0);
			return this;
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder addAnyContents0(List<String> anyContents0s) {
			if (anyContents0s != null) {
				for (final String toAdd : anyContents0s) {
					this.anyContents0.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("anyContents0")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("anyContents0")
		@Override
		public PGPDataType.PGPDataTypeBuilder setAnyContents0(List<String> anyContents0s) {
			if (anyContents0s == null) {
				this.anyContents0 = new ArrayList<>();
			} else {
				this.anyContents0 = anyContents0s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("anyContents1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents1")
		@Override
		public PGPDataType.PGPDataTypeBuilder addAnyContents1(String _anyContents1) {
			if (_anyContents1 != null) {
				this.anyContents1.add(_anyContents1);
			}
			return this;
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder addAnyContents1(String _anyContents1, int idx) {
			getIndex(this.anyContents1, idx, () -> _anyContents1);
			return this;
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder addAnyContents1(List<String> anyContents1s) {
			if (anyContents1s != null) {
				for (final String toAdd : anyContents1s) {
					this.anyContents1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("anyContents1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("anyContents1")
		@Override
		public PGPDataType.PGPDataTypeBuilder setAnyContents1(List<String> anyContents1s) {
			if (anyContents1s == null) {
				this.anyContents1 = new ArrayList<>();
			} else {
				this.anyContents1 = anyContents1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PGPDataType build() {
			return new PGPDataType.PGPDataTypeImpl(this);
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPDataType.PGPDataTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPgpKeyID()!=null) return true;
			if (getPgpKeyPacket()!=null) return true;
			if (getAnyContents0()!=null && !getAnyContents0().isEmpty()) return true;
			if (getAnyContents1()!=null && !getAnyContents1().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPDataType.PGPDataTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PGPDataType.PGPDataTypeBuilder o = (PGPDataType.PGPDataTypeBuilder) other;
			
			
			merger.mergeBasic(getPgpKeyID(), o.getPgpKeyID(), this::setPgpKeyID);
			merger.mergeBasic(getPgpKeyPacket(), o.getPgpKeyPacket(), this::setPgpKeyPacket);
			merger.mergeBasic(getAnyContents0(), o.getAnyContents0(), (Consumer<String>) this::addAnyContents0);
			merger.mergeBasic(getAnyContents1(), o.getAnyContents1(), (Consumer<String>) this::addAnyContents1);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PGPDataType _that = getType().cast(o);
		
			if (!Objects.equals(pgpKeyID, _that.getPgpKeyID())) return false;
			if (!Objects.equals(pgpKeyPacket, _that.getPgpKeyPacket())) return false;
			if (!ListEquals.listEquals(anyContents0, _that.getAnyContents0())) return false;
			if (!ListEquals.listEquals(anyContents1, _that.getAnyContents1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgpKeyID != null ? pgpKeyID.hashCode() : 0);
			_result = 31 * _result + (pgpKeyPacket != null ? pgpKeyPacket.hashCode() : 0);
			_result = 31 * _result + (anyContents0 != null ? anyContents0.hashCode() : 0);
			_result = 31 * _result + (anyContents1 != null ? anyContents1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PGPDataTypeBuilder {" +
				"pgpKeyID=" + this.pgpKeyID + ", " +
				"pgpKeyPacket=" + this.pgpKeyPacket + ", " +
				"anyContents0=" + this.anyContents0 + ", " +
				"anyContents1=" + this.anyContents1 +
			'}';
		}
	}
}
